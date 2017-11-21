package com.reger.test.core;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.reger.dubbo.rpc.filter.ProviderFilter;
import com.reger.dubbo.rpc.filter.Utils;
import com.reger.test.exception.TestRuntimeException;

@SpringBootApplication 
public class DubboLeaderApplication implements InitializingBean,DisposableBean {
	
	private static final Logger log = LoggerFactory.getLogger(DubboLeaderApplication.class);

	private static CountDownLatch latch=new CountDownLatch(1);
	private static ConfigurableApplicationContext context;
	
	public static void main(String[] args) throws InterruptedException {
		context = SpringApplication.run(DubboLeaderApplication.class, args);
		latch.await();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Utils.register(TestRuntimeException.class);
		System.err.println("服务提供者启动完毕------>>启动完毕");
	}

	@Override
	public void destroy() throws Exception {
		latch.countDown();
		context.close();
		System.err.println("服务提供者关闭------>>服务关闭");
	}
	
	/**
	 * 用于消费端的通用异常处理
	 * @return
	 */
	@Bean
	public ProviderFilter providerFilter(){
		return ( invoker, invocation)->{
			log.info("方法{}被调用 ", invoker.getInterface());
			return invoker.invoke(invocation);
		};
	}
	
	
}

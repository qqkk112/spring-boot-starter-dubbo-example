package com.reger.test.core;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.reger.dubbo.rpc.filter.ProviderFilter;

@SpringBootApplication 
public class DubboLeaderApplication implements InitializingBean,DisposableBean {
	private static CountDownLatch latch=new CountDownLatch(1);
	private static ConfigurableApplicationContext context;
	
	public static void main(String[] args) throws InterruptedException {
		context = SpringApplication.run(DubboLeaderApplication.class, args);
		latch.await();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.err.println("服务提供者启动完毕------>>启动完毕");
	}

	@Override
	public void destroy() throws Exception {
		latch.countDown();
		context.close();
		System.err.println("服务提供者关闭------>>服务关闭");
	}
	
	@Bean
	public ProviderFilter providerFilter(){
		return ( invoker, invocation)->{
			System.err.println("接口被调用 ------》》"+invoker.getInterface());
			return invoker.invoke(invocation);
		};
	}
	
}

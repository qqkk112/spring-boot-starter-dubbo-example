package com.test.dubbo.main;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication 
public class SpringDubboxConfigApplication implements InitializingBean,DisposableBean {
	private static CountDownLatch latch=new CountDownLatch(1);
	private static ConfigurableApplicationContext context;
	
	public static void main(String[] args) throws InterruptedException {
		context = SpringApplication.run(SpringDubboxConfigApplication.class, args);
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
		System.err.println("服务提供者等待结束------>>服务关闭");
	}
	
}

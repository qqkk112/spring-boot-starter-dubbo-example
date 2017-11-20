package com.reger.test.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.reger.dubbo.rpc.filter.ConsumerFilter;
import com.reger.test.consumer.DubboReferenceConsumer;

@SpringBootApplication(scanBasePackageClasses=DubboReferenceConsumer.class)
public class DubboLeaderApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DubboLeaderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.err.println("服务消费者启动完毕------>>启动完毕");
	}
	
	@Bean
	public ConsumerFilter consumerFilter(){
		return ( invoker, invocation)->{
			System.err.println("调用接口 ------》》"+invoker.getInterface());
			return invoker.invoke(invocation);
		};
	}
}

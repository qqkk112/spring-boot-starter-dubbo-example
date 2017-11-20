package com.reger.test.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= "com.test.dubbo.consumer")
public class DubboLeaderApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DubboLeaderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.err.println("服务消费者启动完毕------>>启动完毕");
	}
	
}

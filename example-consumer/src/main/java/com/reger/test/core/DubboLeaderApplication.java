package com.reger.test.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.reger.test.consumer,com.reger.test.web")
public class DubboLeaderApplication implements CommandLineRunner, DisposableBean {

	private static final Logger log = LoggerFactory.getLogger(DubboLeaderApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DubboLeaderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("服务消费者启动完毕------>>启动完毕");
	}

	@Override
	public void destroy() throws Exception {
		log.info("服务消费者------>>关闭");
	}
}

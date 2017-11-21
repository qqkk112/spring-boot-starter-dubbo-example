package com.reger.test.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.reger.dubbo.rpc.filter.ConsumerFilter;
import com.reger.test.consumer.DubboReferenceConsumer;

@SpringBootApplication(scanBasePackageClasses = DubboReferenceConsumer.class)
public class DubboLeaderApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DubboLeaderApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DubboLeaderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("服务消费者启动完毕------>>启动完毕");
	}

	@Bean
	public ConsumerFilter consumerFilter1() {
		return (joinPoint) -> {
			log.info("1.调用接口 ------》》" + joinPoint.getInvoker().getInterface());
			return joinPoint.proceed();
		};
	}
	@Bean
	public ConsumerFilter consumerFilter2() {
		return (joinPoint) -> {
			log.info("2.调用接口 ------》》" + joinPoint.getInvoker().getInterface());
			return joinPoint.proceed();
		};
	}
	@Bean
	public ConsumerFilter consumerFilter3() {
		return (joinPoint) -> {
			log.info("3.调用接口 ------》》" + joinPoint.getInvoker().getInterface());
			return joinPoint.proceed();
		};
	}
}

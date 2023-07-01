package com.example.springaop.learnspringaop;

import com.example.springaop.learnspringaop.aopexample.business.BusinessService1;
import com.example.springaop.learnspringaop.aopexample.business.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringAopApplication implements CommandLineRunner {
	// CLR => SpringApplication 안에 있을때 bean이 실행되야함을 명시함.
	// springboot가 실행되는 순간 실행됨.
	private Logger logger = LoggerFactory.getLogger(getClass());
	private BusinessService1 businessService1;
	private BusinessService2 businessService2;

	public LearnSpringAopApplication(BusinessService1 businessService1, BusinessService2 businessService2) {
		this.businessService1 = businessService1;
		this.businessService2 = businessService2;
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 비즈니스 로직을 추가함.
		logger.info("B1 Value return is {}", businessService1.calculateMax());
		logger.info("B2 Value return is {}", businessService2.calculateMin());
	}
}

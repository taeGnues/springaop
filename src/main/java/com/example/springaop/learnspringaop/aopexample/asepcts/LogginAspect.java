package com.example.springaop.learnspringaop.aopexample.asepcts;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
// AOP Configuration
@Configuration
@Aspect
public class LogginAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // Pointcut- WHEN?
    // execution(* PACKAGE.*.*(..))
    // => 특정 패키지에 속한 모든 클래스의 메소드를 대상으로 호출을 인터셉트하기 위해 정의
    // execution(* com.example.springaop.learnspringaop.aopexample.business.*.*(..))
    // => business package 내 모든 메소드 호출 인터셉
    @Before("com.example.springaop.learnspringaop.aopexample.asepcts.CommonPointcutConfig.businessAndDataPackageConfig()") // 어떤 메소드 호출을 인터셉트 할것인가
    public void logMethodCall(JoinPoint joinPoint){ // 특정 메소드 실
        logger.info("Before Aspect - Method is called -{}", joinPoint);
      // logic - WHAT? : 로그를 출력하려함
    }
    // 이 메소드가 언제 호출될지 정의해야함.
    // 비즈니스 레이어와 데이터 레이어 빈에서 호출되는 메소드 호출을 인터셉트.

    @AfterThrowing(
        pointcut = "execution(* com.example.springaop.learnspringaop.aopexample.*.*.*(..))",
        throwing = "exception"
    ) // 어떤 메소드 호출을 인터셉트 할것인가
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception){ // 특정 메소드 실
        logger.info("After Exception Aspect - Method is called -{} exception -{}", joinPoint, exception);
        // logic - WHAT? : 로그를 출력하려함
    }

    @AfterReturning(
            pointcut = "execution(* com.example.springaop.learnspringaop.aopexample.*.*.*(..))",
            returning = "resultValue"
    ) // 어떤 메소드 호출을 인터셉트 할것인가
    public void logMethodCallAfterReturning(JoinPoint joinPoint, Object resultValue){ // 특정 메소드 실
        logger.info("After Returning Aspect - Method is called -{} returnValue -{}", joinPoint, resultValue);
        // logic - WHAT? : 로그를 출력하려함
    }

}

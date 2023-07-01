package com.example.springaop.learnspringaop.aopexample.asepcts;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Around("com.example.springaop.learnspringaop.aopexample.asepcts.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { // trackTime이 붙은 메소드만 성능측정.
        //ProceedingJoinPoint는 proceed를 호출해 대상 메소드를 실행할 수 있고 around advice를 구현시킴.
        // Start a timer
        long startTimeMillis = System.currentTimeMillis();
        // Execute the method
        Object returnValue = proceedingJoinPoint.proceed();

        //stop the timer
        long stopTimeMillis = System.currentTimeMillis();

        long executionDuration = stopTimeMillis - startTimeMillis;

        logger.info("Around Aspect - {} Method executed in {}", proceedingJoinPoint, executionDuration);

        return returnValue;
    }
}

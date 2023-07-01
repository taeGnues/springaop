package com.example.springaop.learnspringaop.aopexample.asepcts;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.example.springaop.learnspringaop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig(){}
    @Pointcut("bean(*Service*)")
    public void dataPackageConfigUsingBean(){}
    // bean 지시자를 사용하면 bean 이름을 기준으로 인터셉트 대상을 지정할 수 있음.
    // Service가 들어간 모든 bean 인터셉트.

    @Pointcut("@annotation(com.example.springaop.learnspringaop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation(){}

    // 이 annotation을 pointcut으로 지정
}

package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by icttb0 on 20/01/2017.
 */
@Aspect
@Component
public class MyAspect {

    public MyAspect() {
        System.out.println("=================== MyAspect ============================");
    }

    @AfterReturning("execution(* com.example.jpa.*Repository.*(..))")
    private void log(JoinPoint joinPoint){
        System.out.println("=================== MyAspect.log " + joinPoint.getSignature() + " ============================");
    }
}

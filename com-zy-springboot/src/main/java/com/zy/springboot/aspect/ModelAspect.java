package com.zy.springboot.aspect;

import com.zy.springboot.annotation.LoggerTest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Author: zhangya
 * Date: 2019/3/14
 * Time: 11:29
 * Description:
 */
@Aspect
@Component
public class ModelAspect implements Ordered {

    @Around("execution(* com.zy.springboot.impl..*.*(..))")
    public Object process(ProceedingJoinPoint point) throws Throwable {

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        if (method.isAnnotationPresent(LoggerTest.class)) {
            System.out.println(method.getName() + " is proccessed.");
        }
        return point.proceed();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

package com.ishna.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//Logger Support
	Logger myLogger = Logger.getLogger(getClass().getName());
	
	
	//Pointcut Expression
	@Pointcut("execution(* com.ishan.springdemo.controller.*.*(..))")
	private void forController() {
		
	}
	
	@Pointcut("execution(* com.ishan.springdemo.service.*.*(..))")
	private void forService() {
		
	}
	
	@Pointcut("execution(* com.ishan.springdemo.dao.*.*(..))")
	private void forDao() {
		
	}
	
	@Pointcut("forController() || forService() || forDao()")
	private void forAppFlow() {
		
	}
	
	//@Before Advice
	@Before("execution(* com.ishan.springdemo.controller.*.*(..))")
	public void before(JoinPoint joinPoint) {
		//method name
		String method = joinPoint.getSignature().toShortString();
		
		//Log
		myLogger.info("**************@Before Advice *****************" +method);
	}
	
	//@AfterReturningAdvice
	
}

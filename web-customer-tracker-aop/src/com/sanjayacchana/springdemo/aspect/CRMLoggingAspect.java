package com.sanjayacchana.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//set up pointcut declaration
	@Pointcut("execution(* com.sanjayacchana.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.sanjayacchana.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.sanjayacchana.springdemo.dao.*.*(..))")
	private void forDAoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAoPackage()")
	private void forAppFlow() {}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//display the method call
		String theMethodName = theJoinPoint.getSignature().toShortString();
		System.out.println("==> in @Before advice calling method: "+theMethodName);
		
		//display the aruguments to the method
		
		//get the aruguments
		Object[] args = theJoinPoint.getArgs();
		
		//loop through and display args 
		for(Object obj: args) {
			System.out.println("====> aruguments: "+ obj);
		}
	}
	
	//add @AfterReturning advice
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		//display the method call
		String theMethodName = theJoinPoint.getSignature().toShortString();
		System.out.println("==> in @AfterReturning advice calling method: "+theMethodName);
		
		//display the data returned
		System.out.println("==> Result: "+ theResult);
		
	}
	
	
	
	
	
	
	

}

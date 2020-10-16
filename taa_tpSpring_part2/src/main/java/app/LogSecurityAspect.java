package app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogSecurityAspect {

	// -> fonctionnement par genre de regex
	@Before("execution(* app..*.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		System.out.println("\tlog: " + joinPoint.getSignature());
	}

	// securité ??
	@Around("execution(* app..*.*(..))")
	public Object securityServiceAccess(ProceedingJoinPoint joinPoint) throws Throwable {
		return joinPoint.proceed();
	}

}

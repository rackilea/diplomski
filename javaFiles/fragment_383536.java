package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import de.scrum_master.app.BaseError;
import de.scrum_master.app.BaseResponse;
import de.scrum_master.app.ExceptionHandler;

@Aspect
public class ErrorHandler {
    @Around("execution(de.scrum_master.app.BaseResponse<String> *(..))")
    public Object handleError(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        //System.out.println(thisJoinPoint);
        try {
            return thisJoinPoint.proceed();
        } catch (Exception e) {
            BaseError be = ExceptionHandler.errorResponse(e);
            BaseResponse<String> response = new BaseResponse<String>();
            response.setBody("uh-oh!");
            response.setError(be);
            return response;
        }
    }
}
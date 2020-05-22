package test;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @AfterThrowing(pointcut = "execution(public * *(..))", throwing = "ex")
    public void intercept(DataAccessException ex) throws Exception {
        //throw DatabaseException
        System.out.println("DAE");
    }

    @AfterThrowing(pointcut = "execution(public * *(..))", throwing = "ex")
    public void intercept(RuntimeException ex) throws Exception {
        //throw ServiceException
        System.out.println("RE - " + ex.getClass());
    }

}
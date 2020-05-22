package test;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReAspect implements Ordered {

    public int getOrder() {
        return 100;
    }

    @AfterThrowing(pointcut = "execution(public * *(..))", throwing = "ex")
    public void intercept(RuntimeException ex) throws Exception {
        //throw ServiceException
        System.out.println("RE - " + ex.getClass());
        throw new IllegalAccessException("RE2");
    }

}
package experiments.stackoverflow.aspectj;

import javax.inject.Inject;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Configurable;

@Aspect
@Configurable
public class ConfiguredCallAspect {

    private MyConfiguration config;

    public MyConfiguration getConfig() {
        return config;
    }

    @Inject
    public void setConfig(MyConfiguration config) {
        this.config = config;
    }

    /**
     * Pointcut for all calls to ClassA.someMethod().
     */
    @Around("call(* ClassA.someMethod())")
    public void conditionalExecutionOfSomeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Aspect start");
        if (config.shouldExecuteFor(joinPoint.getTarget())) {
            joinPoint.proceed();
        }
        System.out.println("Aspect end");
    }

}
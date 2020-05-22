@Aspect
public class ParameterAspect {

    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void beanAnnotatedWithAtController() {
    }

    @Pointcut("execution(public * *(.., @aspects.MyParamAnnotation (*), ..))")
    public void methodWithAnnotationOnAtLeastOneParameter() {
    }

    @Before("beanAnnotatedWithAtController() " 
            + "&& methodWithAnnotationOnAtLeastOneParameter()")
    public void beforeMethod() {    
        System.out.println("At least one of the parameters are " 
                  + "annotated with @MyParamAnnotation");
    }
}
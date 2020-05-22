@Aspect
public class SecurityAspect{

    @Pointcut("execution(@ForbidIf * *(*))")
    public void annotatedMethodCalled(){}

    @Before("annotatedMethodCalled() && @target(annotation) && target(bean)")
    public void beforeRestrictedMethodCall(
        final ForbidIf annotation, final Object bean){
        final Expression expression =
            new SpelExpressionParser().parseExpression(annotation.value());
        if(!Boolean.TRUE.equals(expression.getValue(bean))){
            throw new IllegalArgumentException();
        }
    }

}
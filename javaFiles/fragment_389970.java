@Aspect
public class SetterAspect {

    private UpdatableDtoManager updatableDtoManager = 
        UpdatableDtoManager.INSTANCE;

    @Pointcut("set(private * demo.*.*)")
    public void setterMethod() {}

    @AfterReturning("setterMethod()")
    public void afterSetMethod(JoinPoint joinPoint) {
        String fieldName = joinPoint.getSignature().getName();
        updatableDtoManager.updateObjectWithUpdatedField(
                fieldName, joinPoint.getTarget());      
    }
}
@AroundInvoke{
public Object invoke(InvocationContext ctx) throws Exception {
    if(ctx.getTarget() instanceof BeanWithListProperty) {
        Object toProceed = ctx.proceed(); 
        BeanWithListProperty bean = (BeanWithListProperty) ctx.getTarget();
        List list = bean.getMyList();
        return toProceed;
    }
    return ctx.proceed();
}
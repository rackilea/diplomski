@Resource(name="txnEventSubscriber")
private EventSubscriberImpl subscriber;

@Bean
public Advice myAdvice() {
    return new AfterReturningAdvice() {
        public void afterReturning(Object returnValue, Method method, Object[] args, Object target)
        {
            System.out.println("inside advice");
        }
    };
}

@Bean
public Advisor myAdvisor() {
    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    pointcut.setExpression("execution(public * com.foo.bar.EventSubscriberImpl.*(..))");
    return new DefaultPointcutAdvisor(pointcut, myAdvice());
}
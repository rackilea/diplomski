class BusinessLogic {
    @Inject public EntityManager em;

    @Transactional
    publc void doSomething() {
       //...
       em.persist(myObj);
    }

    @Transactional
    public void doSomethingElse() {
       //...
       em.delete(myObj);
    }
}

class TransactionalInterceptor implements MethodInterceptor {
    @Inject static Injector injector;
    public Object intercept(MethodInvocation invocation) {
        EntityManager em = injector.getInstance(EntityManager.class);
        em.getTransaction().begin();
        Object result = invocation.proceed();
        em.getTransaction().commit();
        return result;
    }
}
class TransactionalModule extends AbstractModule {
    public void configure() {
        requestStaticInjection(TransactionalInterceptor.class);
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(Transactional.class),
                 new TransactionalInterceptor());
    }
}
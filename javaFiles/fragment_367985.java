public class CallerPackageAwareProxyFactoryBean implements
        FactoryBean<MyService>, ApplicationContextAware {

    private Class<?> targetServiceType;
    private ApplicationContext applicationContext;

    private InvocationHandler invocationHandler = new InvocationHandler() {
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            if (ReflectionUtils.isEqualsMethod(method)) {
                // Only consider equal when proxies are identical.
                return (proxy == args[0]);
            } else if (ReflectionUtils.isHashCodeMethod(method)) {
                // Use hashCode of service locator proxy.
                return System.identityHashCode(proxy);
            } else if (ReflectionUtils.isToStringMethod(method)) {
                return "Service dispatcher: " + targetServiceType.getName();
            } else {
                String callerPackageFirstLevel = getCallerPackageFirstLevel();
                Map<String, ?> beans = applicationContext
                        .getBeansOfType(targetServiceType);
                for (Map.Entry<String, ?> beanEntry : beans.entrySet()) {
                    if (beanEntry.getKey().startsWith(callerPackageFirstLevel)) {
                        return method.invoke(beanEntry.getValue(), args);
                    }
                }
                throw new IllegalArgumentException(
                        String.format(
                                "Could not find any valid bean to forward call for method %s.",
                                method.getName()));
            }
        }

        private String getCallerPackageFirstLevel() {
            Throwable t = new Throwable();
            StackTraceElement[] elements = t.getStackTrace();

            String callerClassName = elements[3].getClassName();
            return callerClassName.split("\\.")[0];
        }
    };

    public MyService getObject() throws Exception {
        return (MyService) Proxy.newProxyInstance(Thread.currentThread()
                .getContextClassLoader(), new Class<?>[] { MyService.class },
                invocationHandler);
    }

    public Class<?> getObjectType() {
        return MyService.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void setTargetServiceType(Class<?> targetServiceType) {
        this.targetServiceType = targetServiceType;
    }

}
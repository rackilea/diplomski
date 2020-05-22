public class ProxyTest
{
    public static void main(String... args)
    {
        List<?> instances = Arrays.asList(new A1());
        List<ARunnable> runnableInstances = new ArrayList<ARunnable>(instances.size());
        for (Object instance : instances)
        {
            ARunnable runnableInstance = (ARunnable)Proxy.newProxyInstance(
                                            ARunnable.class.getClassLoader(), 
                                            new Class<?>[] {ARunnable.class}, 
                                            new RunnableWrapper(instance));
            runnableInstances.add(runnableInstance);
        }

        //Now we have a list of ARunnables!
        //Use them for something
        for (ARunnable runnableInstance : runnableInstances)
        {
            runnableInstance.run();
        }
    }

    private static class RunnableWrapper implements InvocationHandler
    {
        private final Object instance;

        public RunnableWrapper(Object instance)
        {
            this.instance = instance;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable
        {
            //Ensure that your methods match exactly or you'll get NoSuchMethodExceptions here
            Method delegateMethod = instance.getClass().getMethod(method.getName(), method.getParameterTypes());
            return(delegateMethod.invoke(instance, args));
        }
    }

    public static class A1
    {
        public void run()
        {
            System.out.println("Something");
        }
    }

    public static interface ARunnable
    {
        public void run();
    }
}
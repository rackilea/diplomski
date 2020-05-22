public static class Synchronizer implements InvocationHandler{

    private final Object objectToSync;

    public Synchronizer(Object objectToSync){
        this.objectToSync = objectToSync;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        synchronized (objectToSync){
            return method.invoke(objectToSync, args);
        }
    }
}

public static void main(String ... args) {

    List<Integer> originalList = new ArrayList<>();

    List<Integer> syncList = (List<Integer>) Proxy.newProxyInstance(Synchronizer.class.getClassLoader(), new Class[]{List.class}, new Synchronizer(originalList));

}
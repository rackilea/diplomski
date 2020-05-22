public final class InstanceManager<T> {
    private final Map<Class<?>, List<Reference<T>>> refMap = (
        new HashMap<Class<?>, List<Reference<T>>>()
    );

    public synchronized <U extends T> U manage(U instance) {
        Class<?> cls = instance.getClass();
        List<Reference<T>> refList = refMap.get(cls);

        if(refList == null) {
            refList = new LinkedList<Reference<T>>();
            refMap.put(cls, refList);
        }

        refList.add(new WeakReference<T>(instance));
        return instance;
    }

    public synchronized <U extends T> List<U> getAll(Class<U> cls) {
        List<U> returnList = new LinkedList<U>();

        List<Reference<T>> refList = refMap.get(cls);
        if(refList != null) {

            Iterator<Reference<T>> it = refList.iterator();
            while(it.hasNext()) {
                T instance = it.next().get();

                if(instance == null) {
                    it.remove();
                } else {
                    returnList.add(cls.cast(instance));
                }
            }
        }

        return returnList;
    }
}
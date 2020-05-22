public static HashMap<Class, Object> instances = new HashMap<Class, Object>();
public Object getInstance(Class clazz) {
    if (instances.constainsKey(clazz)) {
        return instances.get(clazz);
    } else {
        Object o = clazz.newInstance();
        instances.put(clazz, o);
        return o
    }
}
public class SingletonFactory {
    public static Map<String,Object> objectFactory = new HashMap<String, Object>();

    public static <T> T getInstance(Class<T> c){
        String key = c.toString();
        Object instance= objectFactory.get(key);
        if(instance == null){
            synchronized (c) {
                try{
                    instance = c.newInstance();
                    objectFactory.put(key, instance);
                }catch(IllegalAccessException | InstantiationException e){
                    throw new RuntimeException("Exception while creating singleton instance for class : "+key+" - Exception Message : "+e);
                }
            }
        }
        return c.cast(instance);
        // or
        return (T) instance;
    }
}
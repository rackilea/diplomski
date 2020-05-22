public class AbstractObject {

    private static Map<Class, Integer> map = Collections.synchronizedMap(new HashMap<>());

    public AbstractObject() {
        Class clazz = this.getClass();
        map.merge(clazz, 1, (x, y) -> x + y);
    }

    public static Map<Class, Integer> getCounters() {
        return Collections.unmodifiableMap(map);
    }
}
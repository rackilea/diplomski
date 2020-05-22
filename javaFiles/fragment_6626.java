import java.lang.invoke.*;

public final class EqualsOperation extends ClassValue<MethodHandle> {
    public static boolean equals(Object o, Object p) {
        if(o == p) return true;
        if(o == null || p == null) return false;
        Class<?> t1 = o.getClass(), t2 = p.getClass();
        if(t1 != t2) t1 = commonClass(t1, t2);
        try {
            return (boolean)OPS.get(t1).invokeExact(o, p);
        } catch(RuntimeException | Error unchecked) {
            throw unchecked;
        } catch(Throwable ex) {
            throw new IllegalStateException(ex);
        }
    }
    private static Class<?> commonClass(Class<?> t1, Class<?> t2) {
        while(t1 != Object.class && !t1.isAssignableFrom(t2)) t1 = t1.getSuperclass();
        return t1;
    }
    static final EqualsOperation OPS = new EqualsOperation();
    static final MethodHandle FALLBACK;
    static {
        try {
            FALLBACK = MethodHandles.lookup().findVirtual(Object.class, "equals",
                MethodType.methodType(boolean.class, Object.class));
        } catch (ReflectiveOperationException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    protected MethodHandle computeValue(Class<?> type) {
        try {
            return MethodHandles.lookup()
                .findVirtual(type, "equals", MethodType.methodType(boolean.class, type))
                .asType(FALLBACK.type());
        } catch(ReflectiveOperationException ex) {
            return FALLBACK;
        }
    }
}
import java.lang.invoke.*;
import java.util.function.BiPredicate;

public final class EqualsOperation extends ClassValue<BiPredicate<Object,Object>> {
    public static boolean equals(Object o, Object p) {
        if(o == p) return true;
        if(o == null || p == null) return false;
        Class<?> t1 = o.getClass(), t2 = p.getClass();
        if(t1 != t2) t1 = commonClass(t1, t2);
        return OPS.get(t1).test(o, p); // test(...) is not reflective
    }
    private static Class<?> commonClass(Class<?> t1, Class<?> t2) {
        while(t1 != Object.class && !t1.isAssignableFrom(t2)) t1 = t1.getSuperclass();
        return t1;
    }
    static final EqualsOperation OPS = new EqualsOperation();
    static final BiPredicate<Object,Object> FALLBACK = Object::equals;

    @Override
    protected BiPredicate<Object,Object> computeValue(Class<?> type) {
        if(type == Object.class) return FALLBACK;
        try {
            MethodType decl = MethodType.methodType(boolean.class, type);
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MethodHandle mh = lookup.findVirtual(type, "equals", decl);
            decl = mh.type();
            BiPredicate<Object,Object> p = (BiPredicate<Object,Object>)
                LambdaMetafactory.metafactory(lookup, "test",
                    MethodType.methodType(BiPredicate.class), decl.erase(), mh, decl)
                .getTarget().invoke();
            return p;
        } catch(Throwable ex) {
            return FALLBACK;
        }
    }
}
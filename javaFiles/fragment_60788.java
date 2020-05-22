package tools.bench;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public abstract class Bench {

    final String name;

    public Bench(String name) {
        this.name = name;
    }

    abstract int run(int iterations) throws Throwable;

    private BigDecimal time() {
        try {
            int nextI = 1;
            int i;
            long duration;
            do {
                i = nextI;
                long start = System.nanoTime();
                run(i);
                duration = System.nanoTime() - start;
                nextI = (i << 1) | 1; 
            } while (duration < 100000000 && nextI > 0);
            return new BigDecimal((duration) * 1000 / i).movePointLeft(3);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }   

    @Override
    public String toString() {
        return name + "\t" + time() + " ns";
    }

    static class C {
        public Integer foo() {
            return 1;
        }
    }

    static final MethodHandle sfmh;

    static {
        try {
            Method m = C.class.getMethod("foo");
            sfmh = MethodHandles.lookup().unreflect(m);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        final C invocationTarget = new C();
        final Method m = C.class.getMethod("foo");
        final Method am = C.class.getMethod("foo");
        am.setAccessible(true);
        final MethodHandle mh = sfmh;

        Bench[] marks = {
            new Bench("reflective invocation (without setAccessible)") {
                @Override int run(int iterations) throws Throwable {
                    int x = 0;
                    for (int i = 0; i < iterations; i++) {
                        x += (Integer) m.invoke(invocationTarget);
                    }
                    return x;
                }
            },
            new Bench("reflective invocation (with setAccessible)") {                   
                @Override int run(int iterations) throws Throwable {
                    int x = 0;
                    for (int i = 0; i < iterations; i++) {
                        x += (Integer) am.invoke(invocationTarget);
                    }
                    return x;
                }
            },
            new Bench("methodhandle invocation") {
                @Override int run(int iterations) throws Throwable {
                    int x = 0;
                    for (int i = 0; i < iterations; i++) {
                        x += (Integer) mh.invokeExact(invocationTarget);
                    }
                    return x;
                }
            },
            new Bench("static final methodhandle invocation") {
                @Override int run(int iterations) throws Throwable {
                    int x = 0;
                    for (int i = 0; i < iterations; i++) {
                        x += (Integer) sfmh.invokeExact(invocationTarget);
                    }
                    return x;
                }
            },
            new Bench("direct invocation") {
                @Override int run(int iterations) throws Throwable {
                    int x = 0;
                    for (int i = 0; i < iterations; i++) {
                        x += invocationTarget.foo();
                    }
                    return x;
                }
            },
        };
        for (Bench bm : marks) {
            System.out.println(bm);
        }
    }
}
package bench;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicReferenceArray;

@State(Scope.Benchmark)
@Threads(4)
public class Queue {
    private static final Unsafe unsafe = getUnsafe();
    private static final long base = unsafe.arrayBaseOffset(Object[].class);
    private static final int scale = unsafe.arrayIndexScale(Object[].class);

    private AtomicReferenceArray<Object> atomic;
    private Object[] buffer;
    private int capacity;

    @Param({"0", "25"})
    private volatile int index;

    @Setup
    public void setup() {
        capacity = 32;
        buffer = new Object[capacity];
        atomic = new AtomicReferenceArray<>(capacity);
    }

    @Benchmark
    public void atomicArray() {
        atomic.set(index, "payload");
    }

    @Benchmark
    public void unsafeArrayLength() {
        int index = this.index;
        if (index < 0 || index >= buffer.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        unsafe.putObjectVolatile(buffer, base + index * scale, "payload");
    }

    @Benchmark
    public void unsafeCapacityField() {
        int index = this.index;
        if (index < 0 || index >= capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        unsafe.putObjectVolatile(buffer, base + index * scale, "payload");
    }

    private static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new AssertionError("Should not happen");
        }
    }
}
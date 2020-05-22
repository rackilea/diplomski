@BenchmarkMode({ Mode.AverageTime })
@Warmup(iterations = 10, batchSize = 1)
@Measurement(iterations = 10, batchSize = 1)
@Fork(1)
@State(Scope.Thread)
public class MyBenchmark {

    int[] input;

    static final Map<Class<?>, Map<Class<?>, Function<?, ?>>> cacheGeneric = new HashMap<>();

    @Setup
    public void setup() {
        input = new Random(1).ints().limit(500_000).toArray();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public long[] manual() {
        long[] result = new long[input.length];
        for(int i = 0 ; i < input.length; i++) {
            result[i] = input[i];
        }
        return result;
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public long[] cachedGeneric() {
        return getWrapped(int[].class, long[].class).apply(input);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public long[] reflective() throws Throwable {
        return genericMethodHandleObject(long[].class, input);
    }

    static Map<Class<?>, MethodHandle> metHanGettersObj = Map.of(int[].class, MethodHandles.arrayElementGetter(int[].class).asType(MethodType.methodType(Object.class, Object.class, int.class)));
    static Map<Class<?>, MethodHandle> metHanSettersObj = Map.of(long[].class, MethodHandles.arrayElementSetter(long[].class).asType(MethodType.methodType(void.class, Object.class, int.class, Object.class)));
    static <F, T> T genericMethodHandleObject(Class<T> to, F array) throws Throwable {
        int length = Array.getLength(array);
        Object newArray = Array.newInstance(to.getComponentType(), length);
        MethodHandle getElement = metHanGettersObj.get(array.getClass());
        MethodHandle setElement = metHanSettersObj.get(to);
        for (int i = 0; i < length; i++) setElement.invokeExact(newArray, i, getElement.invokeExact(array, i));
        return (T) newArray;
    }

    @SuppressWarnings("unchecked")
    public static <F, T> Function<F, T> getWrapped(Class<F> from, Class<T> to) {
        return (Function<F, T>) cacheGeneric.computeIfAbsent(from, k -> new HashMap<>())
            .computeIfAbsent(
                to, k -> {
                    MethodHandle mh = convertBootstrap(from, to);
                    return arr -> {
                        try {
                            return (T) mh.invoke(arr);
                        } catch (Throwable e) {
                            throw new RuntimeException(e);
                        }
                    };
                });
    }

    public static MethodHandle convertBootstrap(Class<?> from, Class<?> to) {       
        MethodHandle getter = arrayElementGetter(from);
        MethodHandle setter = arrayElementSetter(to);

        MethodHandle body = explicitCastArguments(setter, methodType(void.class, to, int.class, from.getComponentType()));      
        body = collectArguments(body, 2, getter); // get from 1 array, set in other
        body = permuteArguments(body, methodType(void.class, to, int.class, from), 0, 1, 2, 1);
        body = collectArguments(identity(to), 1, body); // create pass-through for first argument
        body = permuteArguments(body, methodType(to, to, int.class, from), 0, 0, 1, 2);

        MethodHandle lenGetter = arrayLength(from);
        MethodHandle cons = MethodHandles.arrayConstructor(to);
        MethodHandle init = collectArguments(cons, 0, lenGetter);

        MethodHandle loop = countedLoop(lenGetter, init, body);
        return loop;
    }
}
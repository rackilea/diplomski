package tests;

import net.openhft.koloboke.collect.map.hash.HashObjObjMap;
import net.openhft.koloboke.collect.map.hash.HashObjObjMaps;
import org.apache.commons.lang3.tuple.Triple;
import org.openjdk.jmh.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Threads(1)
@Warmup(iterations = 10)
@Measurement(iterations = 20)
@State(Scope.Thread)
public class SoMultiMap {

    public static final int N = Integer.getInteger("runs", 100000);

    private static final double kbk = Double.parseDouble(System.getProperty("kbk", "1.0"));

    static class ImmutableTriple<L, M, R> extends Triple<L, M, R> {
        public final L left;
        public final M middle;
        public final R right;
        private int h;

        public static <L, M, R> ImmutableTriple<L, M, R> of(L left, M middle, R right) {
            return new ImmutableTriple(left, middle, right);
        }

        public ImmutableTriple(L left, M middle, R right) {
            this.left = left;
            this.middle = middle;
            this.right = right;
        }

        public L getLeft() {
            return this.left;
        }

        public M getMiddle() {
            return this.middle;
        }

        public R getRight() {
            return this.right;
        }

        private int innerHash() {
            int h = left.hashCode();
            h *= 1000003;
            h += middle.hashCode();
            h *= 1000003;
            h += right.hashCode();
            return h * 1000003;
        }

        @Override
        public int hashCode() {
            return h != 0 ? h : (h = innerHash());
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ImmutableTriple))
                return super.equals(obj);
            ImmutableTriple triple = (ImmutableTriple) obj;
            if (h != 0 && triple.h != 0 && h != triple.h)
                return false;
            return super.equals(obj);
        }
    }

    ImmutableTriple<String, String, String>[] keys = new ImmutableTriple[N];
    Integer[] values = new Integer[N];
    Map<Triple<String, String, String>, Integer> sourceTupleMap;
    HashObjObjMap<Triple<String, String, String>, Integer> sourceTupleKMap;

    @Setup
    public void fill() {
        sourceTupleMap = new HashMap<>((int) (N / 0.75));
        sourceTupleKMap = HashObjObjMaps.newUpdatableMap((int) (N * kbk));
        for (int i = 0; i < N; i++) {
            keys[i] = ImmutableTriple.of("a-" + i, "b-" + i, "c-" + i);
            values[i] = i;
            sourceTupleKMap.put(keys[i], values[i]);
            sourceTupleMap.put(keys[i], values[i]);
        }
    }

    @Benchmark
    public int tupleHashMapGet(SoMultiMap st) {
        ImmutableTriple<String, String, String>[] keys = st.keys;
        Map<Triple<String, String, String>, Integer> map = st.sourceTupleMap;
        int s = 0;
        for (int i = 0; i < N; i++) {
            s += map.get(keys[i]);
        }
        return s;
    }

    @Benchmark
    public int tupleKolobokeGet(SoMultiMap st) {
        ImmutableTriple<String, String, String>[] keys = st.keys;
        HashObjObjMap<Triple<String, String, String>, Integer> map = st.sourceTupleKMap;
        int s = 0;
        for (int i = 0; i < N; i++) {
            s += map.get(keys[i]);
        }
        return s;
    }

    public static void main(String[] args) {
        SoMultiMap st = new SoMultiMap();
        st.fill();
        st.tupleKolobokeGet(st);
        st.tupleHashMapGet(st);
    }
}
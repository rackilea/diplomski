package bench;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class VarArgs {

    @Benchmark
    public void inlineNonStatic(Blackhole bh) {
        inlineNonStaticVA(bh, "foo", 4, new Object());
    }

    @Benchmark
    public void inlineStatic(Blackhole bh) {
        inlineStaticVA(bh, "foo", 4, new Object());
    }

    @Benchmark
    public void loopNonStatic(Blackhole bh) {
        loopNonStaticVA(bh, "foo", 4, new Object());
    }

    @Benchmark
    public void loopStatic(Blackhole bh) {
        loopStaticVA(bh, "foo", 4, new Object());
    }

    public void inlineNonStaticVA(Blackhole bh, Object... args) {
        if (args.length > 0) bh.consume(args[0]);
        if (args.length > 1) bh.consume(args[1]);
        if (args.length > 2) bh.consume(args[2]);
        if (args.length > 3) bh.consume(args[3]);
    }

    public static void inlineStaticVA(Blackhole bh, Object... args) {
        if (args.length > 0) bh.consume(args[0]);
        if (args.length > 1) bh.consume(args[1]);
        if (args.length > 2) bh.consume(args[2]);
        if (args.length > 3) bh.consume(args[3]);
    }

    public void loopNonStaticVA(Blackhole bh, Object... args) {
        for (Object arg : args) {
            bh.consume(arg);
        }
    }

    public static void loopStaticVA(Blackhole bh, Object... args) {
        for (Object arg : args) {
            bh.consume(arg);
        }
    }
}
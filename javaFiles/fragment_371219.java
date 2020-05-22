import one.profiler.AsyncProfiler;

public class ProfileHeapAlloc {

    public static void main(String[] args) throws Exception {
        AsyncProfiler profiler = AsyncProfiler.getInstance();

        // Dry run to skip allocations caused by AsyncProfiler initialization
        profiler.start("_ZN13SharedRuntime19dtrace_object_allocEP7oopDesci", 0);
        profiler.stop();

        // Real profiling session
        profiler.start("_ZN13SharedRuntime19dtrace_object_allocEP7oopDesci", 0);

        new Long(0);

        profiler.stop();
        profiler.execute("file=alloc.svg");
    }
}
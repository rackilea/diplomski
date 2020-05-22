@State(Scope.Thread)
public class BenchmarkFileSize {

    private List<String> paths;

    @Benchmark
    public long io() {
        long total = 0L;
        for (String path : paths) {
            total += new File(path).length();
        }
        return total;
    }

    @Benchmark
    public  long nio() throws IOException {
        long total = 0L;
        for (String path : paths) {
            total += Files.size(Paths.get(path));
        }
        return total;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
            .include(BenchmarkFileSize.class.getSimpleName())
            .forks(1)
            .build();

        new Runner(opt).run();
    }

    @Setup
    public void buildPaths() {
        // Here the code to build the list of paths to test and affect it to paths
    }
}
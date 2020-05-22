@State(Scope.Thread)
public class BenchmarkFileSize {

    @Param("path")
    public String path;

    @Benchmark
    public long io() {
        return new File(path).length();
    }

    @Benchmark
    public  long nio() throws IOException {
        return Files.size(Paths.get(path));
    }

    public static void main(String[] args) throws RunnerException {
        String[] paths = buildPaths();
        Options opt = new OptionsBuilder()
            .include(BenchmarkFileSize.class.getSimpleName())
            .param("path", paths)
            .forks(1)
            .build();

        new Runner(opt).run();
    }

    private static String[] buildPaths() {
        // Here the code to build the array of paths to test
    }
}
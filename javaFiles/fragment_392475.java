@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 1, time = 5, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class MyBenchmark {

    ClassUnderBenchmark classUnderBenchmark = new ClassUnderBenchmark();

    @State(Scope.Benchmark)
    public static class MyTestState {

        int counter = 0;
        List<String> list = Arrays.asList("aaaaa", "bbbb", "ccc");
        String currentString;

        @Setup(Level.Invocation)
        public void init() throws IOException {
            this.currentString = list.get(counter++);
            if (counter == 3) {
                counter = 0;
            }
        }
    }

    @Benchmark
    @Threads(1)
    @BenchmarkMode(Mode.SampleTime)
    public void test(MyBenchmark.MyTestState myTestState) {
        classUnderBenchmark.toUpper(myTestState.currentString);
    }

    public static class ClassUnderBenchmark {

        Random r = new Random();

        public String toUpper(String name) {
            try {
                Thread.sleep(r.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return name.toUpperCase();
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MyBenchmark.class.getSimpleName())
                .jvmArgs("-XX:+UseG1GC", "-XX:MaxGCPauseMillis=50")
                .build();
        new Runner(opt).run();
    }
}
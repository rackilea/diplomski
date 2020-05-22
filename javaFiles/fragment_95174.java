public class MyBenchmark {

    @State( Scope.Benchmark)
    public static class Values {
        private final ArrayList<Double> values;

        public Values() {
            this.values = new ArrayList<Double>(10000);
            for (int i = 0; i < 10000; i++) {
                this.values.add(Math.random());
            }
        }
    }

    @Benchmark
    public double testMethodInvocation(Values v) {
        double sum = 0;
        for (int i = 0; i < v.values.size(); i++) {
            sum += v.values.get(i);
        }
        return sum;
    }

    @Benchmark
    public double testIntLocalVariable(Values v) {
        double sum = 0;
        int max = v.values.size();
        for (int i = 0; i < max; i++) {
            sum += v.values.get(i);
        }
        return sum;
    }

    @Benchmark
    public double testLongLocalVariable(Values v) {
        double sum = 0;
        long max = v.values.size();
        for (int i = 0; i < max; i++) {
            sum += v.values.get(i);
        }
        return sum;
    }
}
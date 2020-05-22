public class CalculationService extends Service<Double> {
    @Override
    protected Task<Double> createTask() {
        return new Task<Double>() {
            @Override
            protected Double call() throws Exception {
                return doCalculation();
            }
        };
    }
}
import java.util.Random;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.calculateSomething(new Random().nextBoolean());
    }

    private void calculateSomething(boolean isUsingLegacyLogic) {
        CalculationStrategyFactory factory = new CalculationStrategyFactory();
        CalculationStrategy strategy = factory.getCalculationStrategy(isUsingLegacyLogic);
        Calculator calculator = new Calculator(strategy);
        calculator.calculate();
    }

    class Calculator {
        CalculationStrategy calculationStrategy;

        Calculator(CalculationStrategy calculationStrategy) {
            this.calculationStrategy = calculationStrategy;
        }

        // ...

        public double calculate() {
            // original code
            // ...
            // System.out.println("Calculation steps were done in sequential order.");
            // return 0;


            return calculationStrategy.calculate(this);
        }

    }

    private interface CalculationStrategy {
        double calculate(Calculator c);
    }

    private class SequentialCalculationHandler implements CalculationStrategy {
        public double calculate(Calculator c) {
            // ...
            System.out.println("Calculation steps were done in sequential order.");
            return 0;
        }
    }

    private class ParallelCalculationHandler implements CalculationStrategy {
        public double calculate(Calculator c) {
            // ...
            System.out.println("Calculation steps were done in parralel.");
            return 0;
        }
    }

    private class CalculationStrategyFactory {
        public CalculationStrategy getCalculationStrategy(boolean isUsingLegacyLogic) {
            if (isUsingLegacyLogic || Runtime.getRuntime().availableProcessors() == 1) {
                return new SequentialCalculationHandler();
            }

            return new ParallelCalculationHandler();
        }
    }

}
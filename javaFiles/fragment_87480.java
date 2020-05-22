import java.util.concurrent.*;
import java.math.*;

public class IterativeCalculation {

    static class SqrtResult {
        public final BigDecimal value;
        public final Future<SqrtResult> next;
        public SqrtResult(BigDecimal value, Future<SqrtResult> next) {
            this.value = value;
            this.next = next;
        }
    }

    static class SqrtIteration implements Callable<SqrtResult> {
        private final BigDecimal x;
        private final BigDecimal guess;
        private final ExecutorService xs;
        public SqrtIteration(BigDecimal x, BigDecimal guess, ExecutorService xs) {
            this.x = x;
            this.guess = guess; 
            this.xs = xs;
        }

        public SqrtResult call() {
            BigDecimal nextGuess = guess.subtract(guess.pow(2).subtract(x).divide(new BigDecimal(2).multiply(guess), RoundingMode.HALF_EVEN));
            return new SqrtResult(nextGuess, xs.submit(new SqrtIteration(x, nextGuess, xs)));
        }
    }

    public static void main(String[] args) throws Exception {
        long timeLimit = 10000L;
        ExecutorService xs = Executors.newSingleThreadExecutor();
        try {
            long startTime = System.currentTimeMillis();
            Future<SqrtResult> f = xs.submit(new SqrtIteration(new BigDecimal("612.00"), new BigDecimal("10.00"), xs));
            for (int i = 0; System.currentTimeMillis() - startTime < timeLimit; i++) {
                f = f.get().next;                
                System.out.println("iteration=" + i + ", value=" + f.get().value);
            }
            f.cancel(true);
        } finally {
            xs.shutdown();
        }
    }
}
public class RateLimiterTest {
    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(1.0);
        for (int i = 0; i < 10; i++) {
            performOperation(limiter);
        }
    }

    private static void performOperation(RateLimiter limiter) {
        limiter.acquire();
        System.out.println(new Date() + ": Beep");
    }
}
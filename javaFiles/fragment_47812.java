private static volatile int currentNum = 1;
private static volatile int previousNum = 0;

public static void main(String[] args) {
    ScheduledThreadPoolExecutor timer = new ScheduledThreadPoolExecutor(1);
    timer.scheduleWithFixedDelay(() -> {
        System.out.println(currentNum);
        int temp = currentNum;
        currentNum += previousNum;
        if (currentNum < 0) {
            // overflow
            timer.shutdown();
        }
        previousNum = temp;
    }, 0, 1, TimeUnit.MILLISECONDS);
}
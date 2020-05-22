private static final class Printer implements Runnable {

    private final String printMe;

    public Printer(String printMe) {
        this.printMe = printMe;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "says: " + printMe);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }
}

public static void main(String[] args) throws Exception {
    final ExecutorService executorService = Executors.newCachedThreadPool();
    final Map<Integer, Future<?>> futures = new HashMap<>();
    for (int i = 0; i < 10; ++i) {
        futures.put(i, executorService.submit(new Printer("Printer" + i)));
    }
    final Scanner scanner = new Scanner(System.in);
    while (true) {
        final String input = scanner.nextLine();
        if ("EXIT".equalsIgnoreCase(input)) {
            break;
        }
        final Integer threadToStop;
        try {
            threadToStop = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            System.out.println("Not a number");
            continue;
        }
        final Future<?> f = futures.remove(threadToStop);
        if (f == null) {
            System.out.println("Not a valid thread");
            continue;
        }
        f.cancel(true);
    }
    executorService.shutdownNow();
}
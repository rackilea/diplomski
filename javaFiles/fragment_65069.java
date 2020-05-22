public static void main(String... args)
{
    final ExecutorService executorService = Executors.newSingleThreadExecutor(r -> {
        final Thread thread = new Thread(r);
        thread.setDaemon(false); //change me
        return thread;
    });
    executorService.submit(() -> { while (true){ System.out.println("busy"); } });
}
for (Future<String> future : futureList) {
    try {
        if (future.get() != null) {
            executor.shutdownNow();
            decryptedPassword = future.get();
            runTime = System.currentTimeMillis() - startTime;
            printResult();
            break;              // this was missing...
        }
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }
}
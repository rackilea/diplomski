while (!submitFighter1.isDone() || !submitFighter2.isDone()) {
    if (submitFighter1.isDone()) {
        System.out.println("Fighter 1 wins!");
        System.out.println(submitFighter1.get()); // Here!
        submitFighter2.cancel(true);
        executorService.shutdown();
    } else if (submitFighter2.isDone()) {
        submitFighter1.cancel(true);
        System.out.println("Fighter 2 wins!");
        System.out.println(submitFighter2.get()); // And here!
        executorService.shutdown();
    }
}
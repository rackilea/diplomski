Set<Callable<String>> suppliers=new HashSet<>();
suppliers.add(() -> "fast"); // This supplier returns immediately
suppliers.add(() -> {
        Thread.sleep(10_000);
        return "slow";
    }
);

ExecutorService es=Executors.newCachedThreadPool();
try {

    String result = es.invokeAny(suppliers);
    System.out.println(result);

} catch (InterruptedException|ExecutionException ex) {
    Logger.getLogger(MyClass.class.getName()).log(Level.SEVERE, null, ex);
}
es.shutdown();
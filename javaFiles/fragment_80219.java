Future<?> future = service.submit(new MyCallable());
    try {
        future.get(100, TimeUnit.MILLISECONDS);
    } catch (Exception e){
        e.printStackTrace();
        future.cancel(true); //this method will stop the running underlying task
    }
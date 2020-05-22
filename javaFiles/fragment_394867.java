Callable<String> action = new Callable<String>() {
    public String call() {
        return "hello "+Thread.currentThread();
    }
};

FutureTask<String> ft=new FutureTask<>(action);
ft.run();
System.out.println(ft.get());
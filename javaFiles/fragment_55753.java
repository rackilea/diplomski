ExecutorService es = Executors.newFixedThreadPool(2);

Future f1 = es.submit(new Callable<Integer>() {
    public Integer call()
    {
        // Do some processing...
        return someInteger;
    }
});

Future f2 = es.submit(new Callable<Integer>() {
    public Integer call()
    {
        // Do some processing...
        return someInteger;
    }
});

Integer firstInteger = f1.get();
Integer secondInteger = f2.get();
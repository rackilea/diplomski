ExecutorService es=Executors.newFixedThreadPool(
                       Runtime.getRuntime().availableProcessors());
AtomicLong found=new AtomicLong(Long.MAX_VALUE);
LongStream.range(1, 1000000).filter(n -> found.get()==Long.MAX_VALUE)
    .forEach(n -> es.submit(()->{
        if(found.get()>n && fourConsecutives(n)) for(;;) {
            long x=found.get();
            if(x<n || found.compareAndSet(x, n)) break;
        }
    }));
es.shutdown();
try { es.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS); }
catch (InterruptedException ex) {throw new AssertionError(ex); }
long result=found.get();
System.out.println(result==Long.MAX_VALUE? "not found": result);
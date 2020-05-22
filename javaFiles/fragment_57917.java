public static void main(String[] args) throws InterruptedException {
    ExecutorService service = Executors.newSingleThreadExecutor();

    for (String message : "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",")) {
        System.out.println(getThreadName() + ": Sending " + message);
        service.submit(() -> {
            System.out.println(getThreadName() + ": Recevied " + message);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("--- Interrupted");
            }
        });
    }
    service.shutdown();
    service.awaitTermination(1, TimeUnit.SECONDS);
    service.shutdownNow();
}

public static String getThreadName() {
    return Thread.currentThread().getName();
}
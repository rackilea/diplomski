private static ExecutorService tpool = Executors.newFixedThreadPool(20);
    private static final int upper = 140;

    private static AtomicInteger total = new AtomicInteger(0);

public static void main(String[] args) throws Exception {

    int ar[] = new int[upper];
    for(int i = 1 ; i <= upper; i++){
        ar[i-1]=i;
    }

    for(int i = 1 ; i <= ((upper%2) !=0 ? (upper-1):(upper)); i+=2){
        final int a = ar[i-1];
        final int b = ar[i];
            Thread thread = new Thread(new Runnable(){
                public void run() {
                    int res = add(a, b);
                    total.addAndGet(res);
                    return;
            }});
            tpool.execute(thread);
    }
    if(upper%2!=0)
        total.addAndGet(ar[ar.length-1]);

    tpool.shutdown(); //wait for everything to finish
    System.out.println(total.get()); //get the result.
}

private static int add(final int a, final int b){
    return a+b;
}
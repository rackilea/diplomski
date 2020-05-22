public static int sumaConcurrente(int[] arreglo)
    {
        AtomicInteger total = new AtomicInteger(0);

        for(int i = 0 ; i < cantElem; i++){

            int a = arreglo[i];

            tpool.submit(new Runnable(){
                public void run() {
                    total.addAndGet(a);
                    return;
                    }
                });
        }

        tpool.shutdown(); //wait for everything to finish
        try {
              tpool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {  
            }
        return total.get();
    }
public static void main(String... args) throws Exception
    {
        java.util.List<Thread> threads = new java.util.LinkedList<Thread>();
        Flag flag = new Flag();

        for(int i=0; i<20; i++){
            Thread thread=new MyThread(String.format("%04d",i),flag);
            threads.add(thread);
            thread.start();
        }

        flag.setOk(true);            
        for (Thread thread:threads) thread.join();
        System.out.println(MyThread.left);
    }
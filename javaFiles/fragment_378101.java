class MyProducer implements Runnable{

    private FixedBlockingQueueGenerics<? super Integer> queue;
    public MyProducer(FixedBlockingQueueGenerics<? super Integer> queue){
        this.queue = queue;     
    }
    public void run(){
        for ( int i=1; i< 5; i++){
            queue.addElement(new Integer(i));
            System.out.println("adding:"+i);
        }
    }
}
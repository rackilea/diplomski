BlockingQueue<Integer> b = new ArrayBlockingQueue<Integer>(10);

class Offer implements Runnable{
    Random r=new Random();
    public void run(){
        while(System.currentTimeMillis() < end){
            try {
                b.put(r.nextInt());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Take implements Runnable{
    public void run(){
        while(System.currentTimeMillis() < end){
            try {
                b.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
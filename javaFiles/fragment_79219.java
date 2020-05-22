public static void main(String[] args) throws InterruptedException {
    ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
    String endMarker = "END-OF-QUEUE"; // the queue does not allow null
    new Thread( () -> {
        for(;;) try {
            String item = queue.take();
            if(item == endMarker) break;// don't use == for ordinary strings
            System.out.println(item);
        } catch(InterruptedException ex) { return; }
    }).start();

    for (int i = 0; i < 10; i++) {
        queue.put(""+i);
        Thread.sleep(100);
    }
    queue.put(endMarker);
}
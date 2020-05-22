public class Processor implements Runnable {

    private Queue<Socket> requests;
    private boolean shut;

    Processor(Queue<Socket> requests) {
        this.requests = requests;
        shut = false;
    }

    @Override
    public void run() {
        while(!shut) {
            if(requests.isEmpty()) {
                try{
                    Thread.sleep(#rendomeTimemill);
                } catch(InterruptedException e){}
            }else {
                Socket skt = Queue.removeFront();
                try {
                    //System.out.println("processing request from " + socket.getInetAddress().getHostName());
                    //do you want
                } catch (Exception e) {
                } finally {
                    if(skt != null) {
                        try{ skt.close(); skt = null; } catch(IOException ex){}

                    }
                }
            }
        }
    }
    public void stopNow() {
        shut = true;
        Thread.interrupt();
    }
}
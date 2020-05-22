public class HeartBeatThread extends Thread{

    PrintWriter out;
    volatile boolean running = true;

    public HeartBeatThread(Socket socket) throws IOException{
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void shutdown(){
        running = false;
    }

    @Override
    public void run() {
        while(running){
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println("HeartBeat");
        }
    }
}
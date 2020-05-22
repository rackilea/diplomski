public class MiniServer extends Thread{

    private Socket socket = null;

    public MiniServer(Socket socket) {

        super("MiniServer");
        this.socket = socket;

    }

    public void run(){
            //Read input and process here
    }
            //implement your methods here

}
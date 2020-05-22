public class Server {
public static void main(String[] args){
    ServerSocket socket;
    try {
        while(true){
            socket = new ServerSocket(4444);
            Socket socketInstance = socket.accept();
            Thread t = new Thread(new Accept(socketInstance));
            t.start();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

class Accept implements Runnable {
   private Socket socket;
   private int nbrclient = 1;
    public Accept(Socket s){
        socket = s;
    }
    public void run() {
        try {

            in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
            String message = in.readLine();
            System.out.println(message);//this message should be your number
            Double number = Double.parseString(message);

            out = new PrintWriter(socket.getOutputStream());
            //out.println("Pong");
            out.println(2*number +"");
            out.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
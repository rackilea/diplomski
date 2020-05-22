public class EchoServer implements Runnable {

    public void run(){
        try {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Waiting for connection...");
            Socket inboundSocket = ss.accept();

            System.out.println("inputstream read");
            DataInputStream is = new DataInputStream(inboundSocket.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String fromStream = reader.readLine();
            System.out.println(fromStream);

            System.out.println("bufferreader read");
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
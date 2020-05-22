public class EchoClient {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new EchoServer()).start(); // start up the server thread

        String hostName = "localhost";
        int portNumber = 5000;

        try {
            Socket outboundSocket = new Socket(hostName, portNumber);

            System.out.println("Echo client is about to send data to the server...");

            PrintWriter writer = new PrintWriter(outboundSocket.getOutputStream());
            for (int i = 0; i < 100; i++) {
                writer.print("test String");
            }

            System.out.println("Data has been sent");

            writer.flush();
            outboundSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class ClientWorker implements Runnable {
    private Socket socketFromClient;

    public ClientWorker(Socket socketFromClient) {
        super();
        this.socketFromClient = socketFromClient;
    }

    public void run() {

        while(true) {
            ObjectInputStream in = null;
            try {
                in = new ObjectInputStream(socketFromClient.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            try {
                    Message message  = (Message)in.readObject();
                    System.out.println(message);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
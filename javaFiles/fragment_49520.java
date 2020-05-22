public class Server implements Runnable {

    .......
    private Server instance = null;
    private Server(String originalHost) throws Exception {
        setSocket(new Socket(originalHost, 9339));
        os = new DataOutputStream(getSocket().getOutputStream());
        is = new DataInputStream(getSocket().getInputStream());
        Log.logInfo("* Connected to Boom Beach Server");
    }

    public static Server getInstance(String originalHost){
         if(instance == null){
             instance = new Server(originalHost);
         }
         return instance;
    }
    .........

}
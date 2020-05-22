public class myClass {
    private URLConnection serverConnection;
    private void checkServer() throws myException  {
        MyService service = new MyService();
        try {
            serverConnection = service.createConnection();
            serverConnection.connect();
        } catch (Exception e) {
             throw new myException("Server " + SERVER + " not available");
        }
    }
}
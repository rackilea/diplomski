public class ServerInstance {
    public static void main(String[] args) {
        Server server = new Server();
        server.registerHandler(new MyHandlerImpl());

        while (true) {
            // if request comes get input stream
            server.handlerServerRequest(intputStream);
        }
    }
}
class Server {
    public static void main(String[] args) {
        try(ServerSocket ss = new ServerSocket(...)) {
            ChatManager manager = new ChatManager();

            while(true) {
                Client client = new Client(manager, ss.accept());
                new Thread(client).start();
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
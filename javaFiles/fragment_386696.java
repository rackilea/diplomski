class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8181);

        do {
            Socket s = serverSocket.accept();
            try {
                processClient(s);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    private static void processClient(Socket s) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        Message message = (Message) ois.readObject();
        System.out.println(message.toString());
    }
}
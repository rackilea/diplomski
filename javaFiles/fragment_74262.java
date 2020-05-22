public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            Socket socket = serverSocket.accept();
            System.out.println("DONE");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
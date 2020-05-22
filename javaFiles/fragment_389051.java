public static void main(String args[]) {
    try {
        ServerSocket serverSocket = new ServerSocket(3000);
        while (true) {
            Socket socket = serverSocket.accept();
            socket.setSoTimeout(250);
            String message = null;
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            try {
                message = (String) objectInputStream.readObject();
                System.out.println("server read: " + message);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            if ((message != null) && (message.equals("Ping"))) {
                try {
                    objectOutputStream.writeObject("Pong");
                    System.out.println("server sent pong");
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            objectInputStream.close();
            objectOutputStream.close();
            socket.close();
        }
    } catch (IOException ex) {
        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public static void main(String args[]) {
    while (true) {
        try {
            Socket socket = new Socket("localhost", 3000);
            String message;
            socket.setSoTimeout(250);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject("Ping");
            System.out.println("client sent ping");
            try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {
                message = (String) objectInputStream.readObject();
                System.out.println("client read: " + message);
            }
            objectOutputStream.close();
            socket.close();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
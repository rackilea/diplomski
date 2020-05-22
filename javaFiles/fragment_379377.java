public void sendMessage(Message message) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(serverSocket.getOutputStream());
        out.writeObject(message);
        out.flush();
//        out.reset();
    }
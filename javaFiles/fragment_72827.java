public void sendMessage(String message) {
    try {
        out.writeUTF(message);
        out.flush();
    } catch (IOException e) {
        // TODO: Here you HAVE to check if the connection was closed
        // And if it was closed, call a method in the server class to
        // remove this client.
        e.printStackTrace();
    }
}
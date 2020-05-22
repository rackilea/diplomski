Socket socket = null;
try {
    socket = s_socket.accept();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
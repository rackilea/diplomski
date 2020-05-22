public myClass(String ip, int port) throws Exception {
    try {
        socket = new Socket(ip, port);
        in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    } catch (IOException e) {
        throw new Exception("Connecting to HSM failed" + e);
    }
}
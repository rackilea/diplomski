public BufferedImage sendSelector(String selector, String host, int port) throws IOException {
    socket = new Socket(host, port);
    try {
        out = new PrintWriter(socket.getOutputStream(), true);
        out.println(encodePercent(selector) + CRLF);
        in = socket.getInputStream();
        return ImageIO.read(in);
    } finally {
        socket.close(); // closes in and out as well
    }
}
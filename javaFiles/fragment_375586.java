public void close() {
    if (socket != null) {
        try {
            socket.close();
        } catch (IOException e) {
            lgg.info("Closing of socket failed", e);
        }
    }
}
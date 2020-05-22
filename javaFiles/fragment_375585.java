public void close() {
    if (socket != null && !socket.isClosed()) {
        try {
            socket.close();
        } catch (IOException e) {
            lgg.info("Closing of socket failed", e);
        }
    }

    if (in != null) {
        try {
            in.close();
        } catch (IOException e) {
            lgg.info("Closing of inputStream failed", e);
        }
    }

    if (out != null) {
        try {
            out.close();
        } catch (IOException e) {
            lgg.info("Closing of outputStream failed", e);
        }
    }
}
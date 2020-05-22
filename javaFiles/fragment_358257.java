public ServerSocket create(int[] ports) throws IOException {
    for (int port : ports) {
        try {
            return new ServerSocket(port);
        } catch (IOException ex) {
            continue; // try next port
        }
    }

    // if the program gets here, no port in the range was found
    throw new IOException("no free port found");
}
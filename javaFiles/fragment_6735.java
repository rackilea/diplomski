BufferedInputStream input = new BufferedInputStream(sock.getInputStream());
while (!done) {
    // TODO: Rename btrar to something more meaningful
    int bytesRead = input.read(btrar);
    // Do something with the data...
}
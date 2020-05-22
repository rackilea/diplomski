public static char[] receiveBytes(Socket socket, int nBytes) throws IOException {
    char[]            bytes = new char[nBytes];
    InputStreamReader isr   = new InputStreamReader(socket.getInputStream());
    if (isr.read(bytes) == -1)
        throw new EOFException();
    return bytes;
}
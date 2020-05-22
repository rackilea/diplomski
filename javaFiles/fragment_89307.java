in = new BufferedInputStream(socket.getInputStream(), BUFFER_SIZE);
byte[] dataBuffer = new byte[1024 * 16];
int size = 0;
while ((size = in.read(dataBuffer)) != -1) {
    out.write(dataBuffer, 0, size);
}
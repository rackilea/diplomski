byte [] buffer = new byte[1024]; // 1kb buffer
int numBytesRead = fileInputStream.read(buffer);
while (numBytesRead != -1) {
    fileOutputStream.write(buffer, 0, numBytesRead);
    numBytesRead = fileInputStream.read(buffer);
}
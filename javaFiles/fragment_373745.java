HttpUrlConnection conn = ...;
byte[] dataBuffer = new byte[MAX_BYTES];
InputStream stream = conn.getInputStream();
int bytesRead, totalRead = 0;
while (bytesRead != -1) {
    bytesRead = stream.read(dataBuffer, totalRead, bufferLength);
    totalRead += bytesRead;
    if (totalRead > MAX_BYTES) throw new FileTooBigException(...);
}
InputStream in = ...;
CRC32 crcMaker = new CRC32();
byte[] buffer = new byte[someSize];
int bytesRead;
while((bytesRead = in.read(buffer)) != -1) {
    crcMaker.update(buffer, 0, bytesRead);
}
long crc = crcMaker.getValue(); // This is your error checking code
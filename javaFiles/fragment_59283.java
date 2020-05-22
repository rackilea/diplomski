// Keep listening to the InputStream until an exception occurs
byte[] buffer;
int bytes = 0;
try {
    while(mmInStream.read() != (byte) 's')    //TODO: Handle "-1" case
    {}
    //Since we already read out the "s", we need to read 4 more bytes, to regain alignment.
    mmInStream.read();
    mmInStream.read();
    mmInStream.read();
    mmInStream.read();
    //Now, the next byte read should be an "s".
} catch (IOException e) {
    return;
}
while (true) {
(...)
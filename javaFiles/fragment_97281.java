int ch1 = aInputStreamOfSocket.read();
int ch2 = aInputStreamOfSocket.read();
int ch3 = aInputStreamOfSocket.read();
int ch4 = aInputStreamOfSocket.read();
if ((ch1 | ch2 | ch3 | ch4) < 0) {
    throw new EOFException();
}
int theInt = ch1 + (ch2 << 8) + (ch3 << 16) + (ch4 << 24);
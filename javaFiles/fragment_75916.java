int BUF_SIZE = 512;
URL fileURL = new URL("http://www.somewhere.com/someurl.jpg");
InputStream inputStream = fileURL.openStream();
byte [] smallBuffer = new byte[BUF_SIZE];
ByteArrayOutputStream largeBuffer = new ByteArrayOutputStream();
int numRead = BUF_SIZE;
while(numRead == BUF_SIZE) {
    numRead = inputStream.read(smallBuffer,0,BUF_SIZE);
    if(numRead > 0) {
        largeBuffer.write(smallBuffer,0,BUF_SIZE);
    }
}
byte [] bytes = largeBuffer.toByteArray();
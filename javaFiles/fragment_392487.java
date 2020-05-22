byte[] buffer = new byte[RS.getResponse_len()];
int totalRead = 0;
while(totalRead<buffer.length) {
    int bytesRead = dataInputStream.read(buffer,totalRead,buffer.length-totalRead);
    if(bytesRead<0) throw new IOException("Data stream ended prematurely");

    totalRead+=bytesRead;
}
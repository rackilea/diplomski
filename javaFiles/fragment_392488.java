byte[] buffer = new byte[10240]; // 10Kb buffer
BufferedInputStream bis = new BufferedInputStream(dataInputStream);
int totalBytesToRead = RS.getResponse_len();
while(totalBytesToRead>0) {
    int bytesRead = bis.read(buffer);
    if(bytesRead<0) throw new IOException("Data stream ended prematurely");
    totalBytesToRead -= bytesRead;
}
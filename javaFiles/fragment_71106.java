byte[] temp = new byte[CHUNK_SIZE];
int bytes = 0;
for(int a = 0; a < chunks; a++) {
    bytes =remoteStream.read(temp, 0, CHUNK_SIZE);
    if(bytes == -1) {
      System.out.println("Downloaded last chunk : Terminating ");
      break;
    }
    stream.write(temp, 0 ,bytes);
}
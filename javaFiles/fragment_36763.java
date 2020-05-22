long remaining = longsize;
long fileBufferLen = filebuffer.length;

while((read = dis.read(filebuffer, 0, (int)Math.min(fileBufferLen, remaining))) > 0){
    ...
}
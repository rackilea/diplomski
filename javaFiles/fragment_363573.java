int buffSize = 2048;
int off = 0;
char[] cbuf = new char[buffSize];
while(true){
    int read = isr.read(cbuf, off, buffSize - off);
    if(read == -1){
        if(off > 0){
            osw.write(cbuf, 0, off);  // Send nonfull buffer
            osw.flush();
        }
        break;
    }else if(off + read == buffSize){
        osw.write(cbuf, 0, buffSize); // Full buffer, send it all
        osw.flush();
        off = 0;
    }else{
        off += read;
    }
}
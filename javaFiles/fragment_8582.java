int index = 0;
int bytesRead = gbuffer.read(gbytes);
while(bytesRead>0 && index<len) {
    index += bytesRead;
    bytesRead = gbuffer.read(gbytes,index,len-index);
}
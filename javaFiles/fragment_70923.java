PushbackReader _in = new PushbackReader(new InputStreamReader(_socket.getInputStream()));
StringBuilder packet = new StringBuilder();
char[] buffer = new char[1024];
// read in as much as we can
int bytesRead = _in.read(buffer);

while(bytesRead > 0) {
    boolean process = false;
    int index = 0;
    // see if what we've read contains a delimiter
    for(index = 0;index<bytesRead;index++) {
        if(buffer[index]=='\n' ||
           buffer[index]=='\r' ||
           buffer[index]=='\u0000') {
            process = true;
            break;
        }
    }
    if(process) {
         // got a delimiter, process entire packet and push back the stuff we don't care about
         _in.unread(buffer,index+1,bytesRead-(index+1));  // we don't want to push back our delimiter
         packet.append(buffer,0,index);
         parsePlayerPacket(packet);
         packet = new StringBuilder();
    }
    else {
         // no delimiter, append to current packet and read some more
         packet.append(buffer,0,bytesRead);
    }
    bytesRead = _in.read(buffer);
}
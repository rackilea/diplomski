byte [] bytes = new byte[4];
int counter = 0;
while((c = fis.read()) != -1){
    if((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)){
        bytes[counter] = (byte)c;
        counter++;
        if(counter == 4){
            // do things with 4 byte array
            counter = 0;
        }
    }
}
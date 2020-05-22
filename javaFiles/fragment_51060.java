byte[] bytes = new byte[20];
int bytesRead = -1;
while ((bytesRead = read(is, bytes)) != -1) {
    // Process the bytes..
    // Note, while bytes.length will always == 20
    // there will only ever be bytesRead worth of 
    // values in the array
}
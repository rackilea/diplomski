int FILE_CHUNK_SIZE = 1024 * 4; //to make it easier to change to 8 KBs
byte[] chunk = new byte[FILE_CHUNK_SIZE];
int bytesRead = 0;
while ((bytesRead = input.read(chunk)) != -1) {
    bos.write(chunk, 0, bytesRead);
}
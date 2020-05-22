InputStream in_bytes = new FileInputStream("intFile.bin");
int nextByte = in_bytes.read();
while(nextByte != -1) {
    System.out.println(nextByte);
    nextByte = in_bytes.read();
}
in_bytes.close();
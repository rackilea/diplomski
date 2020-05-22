InputStream is = new FileInputStream(new File(filePath));
byte[] b = new byte[2];
int n = is.read(b);
if ( n != 2 ){
    //not a gzip file
}
if ( (b[0] == (byte) 0x1f) && (b[1] == (byte)0x8b)){
    //2-byte gzip header
}
GZIPInputStream gzipInputStream = new GZIPInputStream(new FileInputStream(inFilename));
byte[] buf = new byte[1024];
int len;
while ((len = gzipInputStream.read(buf)) > 0) {
    // buf contains uncompressed data      
}
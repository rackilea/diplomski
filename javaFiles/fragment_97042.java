byte[] buffer = new byte[4];
InputStream is = new FileInputStream("somwhere.in.the.dark");
if (is.read(buffer) != buffer.length) { 
    // do something 
}
is.close();
// at this point, the buffer contains the 4 bytes...
byte[] mybytearray = new byte[1024];
//todo: seek the output file to the starting filePosition
//instead of just appending to the end of the file...
fos = new FileOutputStream(fullPath, true);
bos = new BufferedOutputStream(fos);
InputStream is = socket.getInputStream();
do {
    int bytesRead = is.read(mybytearray, 0, mybytearray.length);
    if (bytesRead <= 0) {
        break;
    }
    bos.write(mybytearray, 0, bytesRead);
    filePosition += bytesRead;
} while (true);

bos.close();
is.close();
socket.close();
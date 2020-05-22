OutputStream outToClient = socket.getOutputStream();

byte[] mybytearray = new byte[1024];
File myfile = new File(filePath);
BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myfile));
bis.skip(filePosition);
do {
    int bytesRead = bis.read(mybytearray, 0, mybytearray.length);
    if (bytesRead <= 0) {
        break;
    }
    outToClient.write(mybytearray, 0, bytesRead);
}
white (true);

outToClient.flush();
bis.close();
ServerSocket serverSocket = new ServerSocket(SHARED_PORT);
Socket socket = serverSocket.accept();
InputStream iStream = socket.getInputStream();
FileOutputStream oStream = new SocketOutputStream("filename");
byte[] buffer = new byte[8921];
for(int readCount = iStream.read(buffer); readCount != -1; readCount = iStream.read(buffer)) {
       oStream.write(buffer, 0, readCount);
    }
    oStream.flush();
    oStream.getFD().sync();
    oStream.close();
    iStream.close();
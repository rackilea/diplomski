public void receiveFile(Socket socket, String fileName) throws IOException {
        DataInputStream dis = new DataInputStream(socket.getInputStream()); //get the socket's input stream
        int size = dis.readInt(); //get the size of the file.
        InputStream in = socket.getInputStream(); 
        OutputStream out = new FileOutputStream(fileName); //stream to write out file
        int totalBytesRead = 0;
        byte[] buf = new byte[8192]; //buffer
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            out.write(buf, 0, len); //write buffer
        }

        out.close(); //clean up
        in.close();
}
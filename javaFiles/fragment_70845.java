public void sendFile(Socket socket, File myFile) throws IOException  {
    DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); //get the output stream of the socket
    dos.writeInt((int) myFile.length()); //write in the length of the file

    InputStream in = new FileInputStream(myFile); //create an inputstream from the file
    OutputStream out = socket.getOutputStream(); //get output stream
    byte[] buf = new byte[8192]; //create buffer
    int len = 0;
    while ((len = in.read(buf)) != -1) {
        out.write(buf, 0, len); //write buffer
    }
    in.close(); //clean up
    out.close();
}
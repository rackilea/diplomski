public void sendFile(File file, String fileType, String fileName) {
    try (OutputStream send = new BufferedOutputStream(clientSocket.getOutputStream());
        InputStream fileIn = new BufferedInputStream(new FileInputStream(fileName));) {

        String httpHeader = "";
        httpHeader += "HTTP/1.1 200 OK\n";
        httpHeader += "Content-type: "+ fileType+ "; Charset=UTF-8\n";
        httpHeader += "\n";

        send.write(httpHeader.getBytes("UTF-8"););
        send.flush();

        IOUtils.copy(fileIn, send);
        send.flush();
    } catch (IOException e) {
        System.err.println(e.getMessage());
    }
}
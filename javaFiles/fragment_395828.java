public void sendFile(File file, String fileType, String fileName) {
    try {
        PrintStream send = new PrintStream(clientSocket.getOutputStream());
        // Buffer must not be to low, => fragments
        int length = 0; // (int) file.length();
        FileInputStream fileIn = new FileInputStream(fileName);
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        /* Write until bytes is empty */
        while ((length = fileIn.read(bytes)) != -1) {
            bos.write(bytes, 0, length);
            // send.write(bytes, 0, length);
            // send.flush();
        }
        bos.flush();
        bos.close();
        byte[] data1 = bos.toByteArray();

        String dataStr = new String(data1, "UTF-8");

        System.out.print(dataStr);
        send.println("HTTP/1.1 200 OK");
        send.println("Content-type: "+ fileType+ "; Charset=UTF-8");
        send.println("");
        send.println(dataStr);

        send.flush();
        send.close();

        fileIn.close();
    } catch (IOException e) {
        System.err.println(e.getMessage());
    }
}
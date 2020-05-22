private static void sendFile(String path) {
    if (path == null) {
        throw new NullPointerException("Path is null");
    }

    File file = new File(path);
    Socket socket = null;
    try {
        System.out.println("Connecting to server...");
        socket = new Socket(HOSTNAME, PORT);
        System.out.println("Connected to server at "
                + socket.getInetAddress());

        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(socket.getOutputStream()));) {
            dos.writeUTF(file.getName());
            dos.writeLong(file.length());

            System.out.println("Sending " + file.getName() + " ("
                    + file.length() + " bytes) to server...");
            writeFile(file, dos);
            System.out.println("Finished sending " + file.getName()
                    + " to server");
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
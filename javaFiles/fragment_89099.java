class Server {
    public void serve(int port) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            for(;;) {
                Socket clientSocket = serverSocket.accept();
                clientSocket.setTcpNoDelay(true);
                Thread clientThread = new Thread(() -> handleClient(clientSocket));
                clientThread.start();
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        try (
            Socket socket = clientSocket; // tricks try-with-resource into handling the socket
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))
             ) {

            while (true) {
                String command = reader.readLine();
                switch (command) {
                    case "quit":
                        Util.send(writer, "ok");
                        return; // ends this thread.
                    case "time":
                        Util.send(writer, String.valueOf(System.currentTimeMillis()));
                        break;
                }
            }

        } catch (IOException e) {
            System.out.println("Client connection closed due to " + e);
            // maybe do something
        }
    }
}
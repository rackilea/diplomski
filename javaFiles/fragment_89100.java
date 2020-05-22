class Client {
    public void connect(String host, int port) throws UnknownHostException, IOException {
        try (
            Socket socket = new Socket(host, port);
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))
            ) {

            socket.setTcpNoDelay(true);

            Util.send(writer, "time");
            String time = reader.readLine();
            System.out.println("Server time: " + time);
            Util.send(writer, "quit");
            System.out.println(reader.readLine());
            return;
        }
    }
}
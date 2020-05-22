try (ServerSocket serverSocket = new ServerSocket(this.port)) {
    if (this.listening && (this.other == null || this.other.isClosed())) {
        System.out.println("Looking for connection on port " + serverSocket.getLocalPort());
        this.in = null;
        this.out = null;
        this.other = serverSocket.accept();
        this.in = new BufferedReader(new InputStreamReader(this.other.getInputStream()));
        this.out = new PrintWriter(this.other.getOutputStream(), true);
    } else if (this.in != null) {System.out.println("Looking for input");
        String input = this.in.readLine();
        System.out.println("Received '" + input + "'");

        if (input != null) {
            // Process input
        }
    }
} catch (IOException ioe) {
    ioe.printStackTrace();
}
public void connect() {
    try {
        socket = new Socket(hostName, portNumber);
        writer = new PrintWriter(socket.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    } catch (UnknownHostException e) {
        System.err.println("Could not resolve the host name '" + hostName + "'.");
    } catch (IOException e) {
        System.err.println(
            "Could not get the I/O for the connection to '" + hostName + "'."
        );
    }
}

private void listenForMessages() {
    while (true) {
        try {
            System.out.println("In loop!");
            // Write the message for the server
            writer.println(message);
            // Read the message from the server
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
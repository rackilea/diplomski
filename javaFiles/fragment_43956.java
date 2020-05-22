while (true) {
    try {
        clientSocket = serverSocket.accept();
        writer = new PrintWriter(clientSocket.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while (true) {
            // Read the message from the client
            System.out.println(reader.readLine());
            // Write the message for the client
            writer.println(message);
        }


    } catch (IOException e) {
        System.err.println(e.getMessage());
        break;
    }
}
while (true) {
    Socket connectionSocket = welcomeSocket.accept();
    BufferedReader inFromClient =
            new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
    DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

    while(true) {
        clientSentence = inFromClient.readLine();
        if (clientSentence != null && clientSentence.trim().isEmpty()) {
            break;
        } else {
            System.out.println("Received: " + clientSentence);
        }
    }

    outToClient.writeBytes("HTTP/1.1 200 OK\n\nHello world");
    outToClient.close();
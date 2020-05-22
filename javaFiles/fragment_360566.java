ServerSocket socket = new ServerSocket(6789);
while (true) {
    Socket connectionSocket = welcomeSocket.accept();
    BufferedReader socketReader = new BufferedReader(new InputStreamReader(
                                      connectionSocket.getInputStream()));
    String line = socketReader.readLine();
    int threadId = Integer.parseInt(line);
    // Now, use threadId to locate the appropriate thread 
    // and send a notification to it.
}
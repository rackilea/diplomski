// create this once per socket.
final PrintWriter out = new PrintWriter(
      new OutputStreamWriter(tempSocket.getOutputStream(), "UTF-8"), true);

public void sendServerMessage(String action) {
    // assuming there is no newlines in the message
    printWriter.println(action);  // auto flushed.
}

// create this once per socket
BufferedReader in = new BufferedReader(
    new InputStreamReader(tempSocket.getInputStream(), "UTF-8"));     

public String getClientMessage() throws IOException {
     // read until the end of a line, which is the end of a message.
      return in.readLine();
}
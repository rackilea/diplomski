ServerThread(Client client, Socket socket,  String userName) {
    this.client = client;
    this.socket = socket;
    this.userName = userName;
    messagesToSend = new LinkedList<String>();
}

public void run() {
    try
    {
        JTextArea test2 = this.client.getTextArea_Receive();
        String test3 = "Hello World";
        test2.append(test3);
    } 
    catch (IOException e)
    {}
}
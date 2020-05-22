BufferedReader FromServer = 
    new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
BufferedReader inFromUser =
    new BufferedReader(new InputStreamReader(System.in));

while (true) {  
    // Check if there's anything to receive
    while (FromServer.ready()) {
        // receive from server
        System.out.println(FromServer.readLine());
    }
    if (inFromUser.ready()) {
        int ch = inFromUser.read();

        // write to server
        outToServer.writeChar(ch);
    }


}
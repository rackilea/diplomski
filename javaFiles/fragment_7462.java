private void startClient(Client client, Scanner scan)
{
    try
    {
        //Create new socket and wait for network communication
        Socket socket = new Socket(serverHost, serverPort);
        Thread.sleep(1000);

        //Create thread and start it
        ServerThread serverThread = new ServerThread(client, socket, userName);
        serverAccessThread.run();
    }
}
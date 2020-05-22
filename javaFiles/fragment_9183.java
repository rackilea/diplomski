ServerSocket defaultSocket = new ServerSocket(DEFAULT_PORT_NUMBER);

    System.out.println("Listening on port: " + DEFAULT_PORT_NUMBER);
    while (true){
        Socket connectionSocket = defaultSocket.accept();
        BufferedReader fromClient= new BufferedReader(new     InputStreamReader(connectionSocket.getInputStream()));
        String msg = fromClient.readLine();
        System.out.println("Recieved: " + msg);
    }
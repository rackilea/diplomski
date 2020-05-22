System.out.println("Listening on port: " + DEFAULT_PORT_NUMBER);
Socket connectionSocket = defaultSocket.accept();
BufferedReader fromClient= new BufferedReader(new     InputStreamReader(connectionSocket.getInputStream()));
String msg = "";
while ((msg = fromClient.readLine()) != null){    
    System.out.println("Recieved: " + msg);
}
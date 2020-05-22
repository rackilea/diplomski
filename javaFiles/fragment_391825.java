// create connection
Socket cs = new Socket(<dest-hostname>, <port-num>);
DataOutputStream ds = new DataOutputStream(cs.getOutputStream() );

// send stuff
ds.writeBytes("is this thing on?");

// close socket and stream
cs.close();
cs = null;
ds = null;

Receive data:
ServerSocket listenSocket;
Socket s = listenSocket.accept();
BufferedReader receivedThing = new BufferedReader( new InputStreamReader( s.getInputStream() ) );

//assuming its plaintext
String msg = receivedThing.readLine();

// close the socker/serversocket
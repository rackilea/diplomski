byte[] buffer = new byte[1024];
int bytes;
inFromServer = nmeaServerSocket.getInputStream();

bytes = inFromServer.read(buffer);
String readMessage = new String(buffer, 0, bytes);
Log.d(TAG, "Message :: "+readMessage);
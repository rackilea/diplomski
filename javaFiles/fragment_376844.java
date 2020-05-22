Socket socket = new Socket();
socket.connect(new InetSocketAddress(host, port), timeout);

// Use this just in case you have to read from the server
BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

// This will be used to send to the server
OutputStream out = socket.getOutputStream();
out.write("This is my message".getBytes("UTF-8"));
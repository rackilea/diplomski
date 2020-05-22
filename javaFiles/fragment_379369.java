BufferedReader inUser = new BufferedReader(new InputStreamReader(System.in));
URL url = new URL("http://www.google.com");
Socket clientSocket = new Socket(url.getHost(), 80);  // url expected
OutputStream output = clientSocket.getOutputStream();
PrintWriter pw = new PrintWriter(output,false);
pw.print("GET index.html HTTP/1.0\r\n");
pw.print("\r\n");
pw.flush();
BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

String modifiedSentence = input.readLine();
System.out.println("FROM SERVER: " + modifiedSentence);
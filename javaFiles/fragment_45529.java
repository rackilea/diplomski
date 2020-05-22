AFUNIXSocket s = AFUNIXSocket.newInstance();
AFUNIXSocketAddress sockAdd = new AFUNIXSocketAddress(new File("file.sock"));

s.connect(sockAdd);

BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
PrintWriter pw = new PrintWriter(s.getOutputStream());


pw.write("GET /to/rest/request HTTP/1.1\r\n");

pw.write("Host: path\r\n");
pw.write("Accept:*/*\r\n");
pw.write("\r\n");
pw.flush();
String reply = "";

Thread.sleep(500);
while (bf.ready())
   reply = reply + bf.readLine() + "\n";
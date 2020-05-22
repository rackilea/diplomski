System.out.println("I am stopping....");
String command="shutdown";
try (Socket socket=new Socket("localhost",6666)) {
  OutputStream out = socket.getOutputStream();
  InputStream in = socket.getInputStream();
  out.write(command.getBytes(Charset.defaultCharset()));

  // Wait until server closes the stream. Could be enhanced with some timeout
  BufferedReader reader = new BufferedReader(new InputStreamReader(in, 
      Charset.defaultCharset())));
  String line = reader.readLine();
  while (line != null) {
    System.out.println(line);
  }
}
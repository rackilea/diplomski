while(true) {
  //Reading the message from the client
  socket = serverSocket.accept();
  InputStream is = socket.getInputStream();
  InputStreamReader isr = new InputStreamReader(is);
  BufferedReader br = new BufferedReader(isr);
  while(true){
    System.out.println(br.readLine());
  }
}
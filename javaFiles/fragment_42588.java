ServerSocket serverSocket = new ServerSocket(port);
       Socket clientSocket = serverSocket.accept();
       BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

       while((inputLine = in.readLine())!=null)
      {
        //Do whatever
      }
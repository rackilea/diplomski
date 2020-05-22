ServerSocket serversocket = null;
    Socket socket = null;
    try{
      //establish a server socket monitoring port 8189 
      //port 8189 is not used by any services
      serversocket = new ServerSocket(8189);
      System.out.println("Listening at 127.0.0.1 on port 8189");

      //wait indefinitely until a client connects to the socket
      socket = serversocket.accept();

      //set up communications for sending and receiving lines of text data
      //establish a bufferedreaderr from the input stream provided by the socket object
      InputStreamReader inputstreamreader = new InputStreamReader(socket.getInputStream());
      BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

      //establish an printwriter using the output streamof the socket object
      //and set auto flush on    
      PrintWriter printwriter = new PrintWriter(socket.getOutputStream(),true);

      //for binary data use
      // DataInputStream and DataOutputStream

      //for serialized objects use
      // ObjectInputStream and ObjectOutputStream

      String datetimestring = (Calendar.getInstance()).getTime().toString();
      printwriter.println("You connected to the Simple Server at " + datetimestring);
      printwriter.println("Send Bye to disconnect.");

      String lineread = "";
      boolean done = false;
      while (((lineread = bufferedreader.readLine()) != null) && (!done)){
        System.out.println("Received from Client: " + lineread);
        printwriter.println("You sent: " + lineread);
        if (lineread.compareToIgnoreCase("Bye") == 0) done = true;
      }
      System.out.println("Closing connection.");
      bufferedreader.close();
      inputstreamreader.close();
      printwriter.close();
      socket.close();
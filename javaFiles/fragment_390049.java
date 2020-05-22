try {
    listen(port);
  }
  catch (IOException e) {
    System.out.println("Server() - IO exception");
    System.out.println(e);

    /*when an exception is caught I close the server socket and try opening it a new one */
    serverSocket.close();

    listen(port);
  }
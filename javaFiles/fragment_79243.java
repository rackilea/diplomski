ServerSocket serverSocket = new ServerSocket(PORT);
Socket socket = serverSocket.accept();
ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
try {
      Object object = objectInputStream.readObject();
      System.out.println("read by the server\t" + object);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
      objectOutputStream.writeObject("this is message by the server");
   }catch(Excetion e) {
    e.printStackTrace();
   }
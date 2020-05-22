// host is the localhost IP
Socket socket = new Socket(host, PORT);
ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
objectOutputStream.writeObject("this is the message by the client");
ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
try {
    System.out.println("read by the client\t" + objectInputStream.readObject());
    }catch(Excetion e) {
    e.printStackTrace();
    }
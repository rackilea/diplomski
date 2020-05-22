Runnable r = new Runnable {
  public void run() {
      try {
        client = new Socket(serverName, port);
        if(client.getInputStream()!=null){
        InputStream inFromServer = client.getInputStream();
        DataInputStream in =  new DataInputStream(inFromServer);
            tex.append("Server: " + in.readUTF() + "\n");}
        client.close();
    } catch(Exception e) {
        e.printStackTrace();
      }
  }
}
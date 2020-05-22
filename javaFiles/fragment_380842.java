} catch (IOException e) {
          e.printStackTrace();
         }
        try {
         os.close();
        } catch (IOException e) {
         e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
      try
      {
        Thread serverThread = new auServer();
        serverThread.run();
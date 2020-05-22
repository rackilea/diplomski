private static void handleClient() {
  new Thread() {
    public void run() {
      Socket link = null;
      ...
        } catch(IOException ioEx) {
           System.out.println("Diskonekcija nije moguca! \nRazlog: " + ioEx.getMessage());
           System.exit(1);
       }    
    } // end outer try
  }.start() // end thread
}
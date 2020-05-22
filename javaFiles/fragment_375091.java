private String folder = "";
public static void main(String[] args) {
try {
  folder = args[0];
  ServerSocket listener = new ServerSocket(port);

  while (true) {
    FileReceiver file_rec = new FileReceiver();
    file_rec.socket = listener.accept();  

    new Thread(file_rec).start();
  }
}
catch (java.lang.Exception ex) {
  ex.printStackTrace(System.out);
}
public class Server {

    public static class ThreadSer extends Thread {
        private Socket s;
        public ThreadSer(Socket s) {
            this.s = s;
}
        @Override
        public void run() {
            try {
              String response = "This is the IP: " + s.getLocalAddress() + " that has come via port: "
                        + s.getLocalPort() + "\r\n";
                ObjectInputStream input = new ObjectInputStream(s.getInputStream()); 
               while(true){
                 Object object = input.readObject();
                 String command = ((String) object).trim(); //trim the string
                 System.out.println(command);
              }
            } catch (IOException e) { System.err.println(e); }
}}}
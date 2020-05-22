class Server extends Thread
    ...
        public void run() {
            while (true) {
                try {
                    Socket s1 = server.accept();
                    Socket s2 = server.accept();
                    new Client(s1, s2).start();  // reads from s1 and redirects to s2
                    new Client(s2, s1).start();  // reads from s2 and redirects to s1
                } catch (IOException e) {
                    System.out.println("Client connection error: " + e.getMessage());
                }
            }
        }

class Client extends Thread {
    Socket s1;
    Socket s2;

    Client(Socket s1, Socket s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public void run() {
        try {
            InputStream is = s1.getInputStream(); 
            OutputStream os = s2.getOutputStream();
            for (int i; (i = is.read()) != -1; i++) {
                os.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
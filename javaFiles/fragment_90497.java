public void startServer() throws IOException{
        ServerSocket serverSocket = new ServerSocket(9209);
        List<ClientThread> clientThreads = new ArrayList<ClientThread>();
        boolean running = true;
        while(running){
            try {
                Socket clientSocket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.run();
                clientThreads.add(clientThread);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for(ClientThread thread : clientThreads){
            thread.shutdown();
        }
}





 public class ClientThread extends Thread{
        private BufferedReader in;
        private volatile boolean running = true;
        private long lastHeartBeat;

        public ClientThread(Socket socket) throws IOException{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        public void shutdown(){
            running = false;
        }

        @Override
        public void run() {
            while(running){
                try {
                    if(in.readLine().equalsIgnoreCase("HeartBeat")){
                        lastHeartBeat = System.currentTimeMillis();
                    }else{
                        //do something else 
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
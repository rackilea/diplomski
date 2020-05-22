// in your main 
serverSocket = new ServerSocket(4444);

try {
    while (true) { 
        clientSocket = serverSocket.accept();

        Thread t = new ClientSocketThread(clientSocket);
        t.start();
    }
} finally {
    serverSocket.close();
}


class ClientSocketThread extends Thread {
    final Socket clientSocket;

    ClientSocketThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        InputStream in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        try
            String inputLine;

            while((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                if(inputLine.equals("start")) {
                     System.out.println("Good");
                }
                if(inputLine.equals("stop")) {
                     System.out.println("Bad");
                }
            }
         } finally {
            in.close()
            clientSocket.close();
         }
    }
}
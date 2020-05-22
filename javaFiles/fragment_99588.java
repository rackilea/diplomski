public class App {
    public static void main(String[] args) {
        new App().run();
    }

    public void run() {
        try {
            System.out.println("Starting...");
            AtomicBoolean running = new AtomicBoolean(true);
            Collection<Socket> sockets = new ArrayList<>();
            Collection<Thread> threads = new ArrayList<>();
            try (ServerSocket socketServer = new ServerSocket(10101)) {
                System.out.println("Started.");
                while (running.get()) {
                    Socket socket = socketServer.accept();
                    sockets.add(socket);
                    if (running.get()) {
                        Thread thread = new Thread(new SocketHandler(socket, running));
                        thread.start();
                        threads.add(thread);
                    }
                }
                System.out.println("Stopping...");
                sockets.forEach(socket -> {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                threads.forEach(thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
            System.out.println("Stopped.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SocketHandler implements Runnable {
        private final Socket socket;
        private final AtomicBoolean running;

        SocketHandler(Socket socket, AtomicBoolean running) {
            this.socket = socket;
            this.running = running;
        }

        @Override
        public void run() {
            try {
                System.out.println("Client connected.");
                try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    boolean connected = true;
                    while (connected){
                        String command = in.readLine();
                        System.out.println("Command received: " + command);
                        if (command == null) {
                            connected = false;
                        } else if (command.equals("shutdown")) {
                            running.set(false);
                            try (Socket tmpSocket = new Socket("localhost", 10101)) {}
                        }
                        // process other commands
                    }
                }
                System.out.println("Client disconnected.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
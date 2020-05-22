public class Server {

    public static void main(String[] args) throws Exception {
        boolean running = true;
        try (ServerSocket socket = new ServerSocket(8080, 0)) {
            while (running) {
                System.out.println("Waiting for client accept.");
                try (final Socket client = socket.accept();
                     final Scanner in = new Scanner(client.getInputStream());
                     final BufferedOutputStream out = new BufferedOutputStream(client.getOutputStream())) {
                    System.out.println("Waiting for client ready.");
                    String line = readLine(in);

                    if ("ready".equals(line)) {
                        writeLine("ready", out);

                        while (running) {
                            line = readLine(in);
                            if (line != null && line.equals("k")) {
                                System.out.println("Server: received stop signal");
                                running = false;
                            } else {
                                Thread.sleep(100);
                                System.out.println("Server: waiting for command.");
                            }
                        }
                    }
                }
            }
        }
    }

    private static String readLine(final Scanner in) {
        String line = in.nextLine();
        System.out.println("Server: client sent " + line);

        return line;
    }

    private static void writeLine(final String line, final BufferedOutputStream out) throws IOException {
        out.write((line + "\n").getBytes());
        out.flush();
    }
}
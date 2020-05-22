public class Client {
    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("localhost", 8080)) {
            try (BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
                 Scanner in = new Scanner(socket.getInputStream())) {
                System.out.println("Client: sending ready.");
                writeLine("ready", out);
                System.out.println("Client: sent ready.");

                String line = in.nextLine();
                if ("ready".equals(line)) {
                    System.out.println("Client: server is ready");
                    writeLine("k", out);
                }
            }
        }
    }

    private static void writeLine(final String line, final BufferedOutputStream out) throws IOException {
        out.write((line +"\n").getBytes());
        out.flush();
    }
}
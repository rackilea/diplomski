public class MyServer {
    public static void main(String args[]) throws IOException {
        try (ServerSocket socket = new ServerSocket(4444);
             Socket s = socket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()))) {

            String text;
            while ((text = in.readLine()) != null) {
                System.out.println(text);
            }
        }
    }
}
public class MyClient {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 4444);
             PrintWriter out = new PrintWriter(socket.getOutputStream())) {
            out.println("c:/users/pinder/desktop/happy.txt");
        }
    }
}
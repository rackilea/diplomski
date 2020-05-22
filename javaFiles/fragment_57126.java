public class SimpleClientMain {
    public static void main(String... args) throws IOException {
        Socket s = new Socket("localhost", 54321);
        InputStream inputStream = s.getInputStream();

        s.getOutputStream().write("Hello\n".getBytes());
        s.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        for (String line; (line = br.readLine()) != null; )
            System.out.println("Got " + line);
        System.out.println("Disconnected.");
        s.close();
    }
}
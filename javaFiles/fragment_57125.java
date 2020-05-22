public class SimpleServerMain {
    public static void main(String... args) throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(54321);
        Socket s = ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        for (String line; (line = br.readLine()) != null; )
            System.out.println("Got " + line);

        PrintStream ps = new PrintStream(s.getOutputStream());
        for (String word : "Hello World Bye Bye!".split(" ")) {
            ps.println(word);
            Thread.sleep(1000);
        }
        s.close();
        ss.close();
    }
}
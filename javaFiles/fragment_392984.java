public class ShutdownTest {

    static PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) throws InterruptedException {

        writer.println("Application Started");
        writer.flush();

        Thread.sleep(2000);

        Runtime.getRuntime().addShutdownHook(new Thread(() ->{
            writer.println("Application shutdown started");
            writer.println("Closing resource");
            writer.close();
        }));

    }
}
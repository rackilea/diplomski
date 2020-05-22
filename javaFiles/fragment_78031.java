import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) throws Exception {
        Process proc = new ProcessBuilder("java", "Child").inheritIO().start();
        proc.onExit().join();
        proc.descendants().map(ProcessHandle::onExit).forEach(CompletableFuture::join);
        System.out.println("Main exiting");
    }
}
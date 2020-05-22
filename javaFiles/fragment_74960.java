import java.io.IOException;

public class OpenWordPad {

    public static void main(String[] args) {
        try {
            System.out.println("Opening WordPad");
            Runtime runTime = Runtime.getRuntime();
            Process process = runTime.exec("write"); // <--- here
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Closing WordPad");
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
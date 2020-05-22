public class Main {
public static void main(String[] args) throws IOException {

        ProcessBuilder pb1 = new ProcessBuilder(
                "bash",
                "-c",
                "cd /Users/nameOfUser/Desktop/someFolder/someSubFolder;commandInThatDirectory");
        pb1.redirectErrorStream(true);
        Process p = pb1.start();
    }
}
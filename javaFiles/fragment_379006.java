import java.io.IOException;

public class App {

    public static Process compile() throws IOException {

        String myFilePath = "C:\\Users\\redacted\\Desktop\\Test.java";
        String javacPath = "C:\\Program Files\\Java\\jdk1.8.0_171\\bin\\javac.exe";

        ProcessBuilder processBuilder = new ProcessBuilder(javacPath, myFilePath);

        return processBuilder.start();
    }

    public static void main(String[] args) throws IOException {

        Process process = compile();

    }
}
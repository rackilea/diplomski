import java.io.*;

public class Starter {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("./dosomething.sh");
        File dir = new File(new File(File.listRoots()[0], "tmp"), "2jvm");
        pb.directory(dir);
        Process p = pb.start();

        BufferedReader read = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String line;
        while ( (line = read.readLine() ) != null) {
            System.out.println("line: " + line);
        }
    }
}
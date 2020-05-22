import java.io.File;

public class Test {
    public static void main(String[] args) {
        File root = new File("D:\\Downloaded"); // path to root folder
        process(root);
    }

    private static void process(File path) {
        File[] subs = path.listFiles();
        if (subs != null) {
            for (File f : subs) {
                if (f.isDirectory()) {
                    process(f);
                } else {
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }
}
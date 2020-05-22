import java.io.File;

public class SourceCodeProgram {

    public static void main(String argv[]) throws Exception {
        File currentFolder = new File(".");
        File workingFolder = new File(currentFolder, "serialized");
        if (!workingFolder.exists()) {
            workingFolder.mkdir();
        }
        System.out.println(workingFolder.getAbsolutePath());
    }
}
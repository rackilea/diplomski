import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilterNonJavaFiles {

    public static void main(String[] args) throws IOException {

        long relevantFileCounter = 0;

        File dir = new File("/Users/lracki/Desktop/diplomski/javaFiles");
        File[] directoryListing = dir.listFiles();

        List<String> javaFiles = new ArrayList<>();

        System.out.println("Files checked : " + directoryListing.length);

        if (directoryListing != null) {
            for (File child : directoryListing) {
                BufferedReader br = new BufferedReader(new FileReader(child));
                String line;
                while ((line = br.readLine()) != null) {
                    /*if (line.contains(";") || line.contains("{") || line.contains("}")) {
                        javaFiles.add(child.getName());
                        break;
                    } else*/ if (line.contains("var ") || line.contains("def ") || line.contains("std::") || line.contains("/>")
                                || line.contains("</") || line.contains("END;") || line.startsWith("<script type")
                                || line.startsWith("<h:") || line.startsWith("<p:") || line.startsWith("<f:") || line.startsWith("#include")
                                || line.startsWith("dependencies {") || line.startsWith("<?xml version=\"1.0\" ")
                                || line.startsWith("<!DOCTYPE html PUBLIC") || line.startsWith("#define") || line.startsWith("using ")
                                || line.startsWith("namespace ") ) {
                        break;
                    } else {
                        javaFiles.add(child.getName());
                        break;
                    }
                }
                br.close();
            }
        }

        for (String file : javaFiles) {
            Files.move(Paths.get("/Users/lracki/Desktop/diplomski/javaFiles/" + file), Paths.get("/Users/lracki/Desktop/diplomski/javaFilesNew/" + file));
            ++relevantFileCounter;
        }

        System.out.println("Files moved :" + relevantFileCounter);
    }
}

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.*;
import java.util.Map;

import static java.nio.file.StandardCopyOption.*;

public class ListOfNumbers {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Documents and Settings\\Administrator\\Desktop\\kk.txt");
        Map f  = Files.readAttributes(path, "*");
        System.out.println(f);
    }
}
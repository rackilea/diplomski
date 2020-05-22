import java.util.*;
import java.io.*;

public class Find {
    List<File> files = new ArrayList<File>();
    List<File> dirs = new ArrayList<File>();
    List<Exception> excs = new ArrayList<Exception>();
    public Find(String path) {
        walk(new File(path));
    }
    void walk(File root) {
        for (File child : getChildren(root)) {
            if (isDirectory(child)) {
                dirs.add(child);
                walk(child);
            } else if (isFile(child)){
                files.add(child);
            }
        }
    }
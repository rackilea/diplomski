import java.io.*;
import java.util.*;

public class FileTree {
    public static void main(String[] args) {
         System.err.println(listFiles(new File(args[0]), new FileFilter() {   
            @Override public boolean accept(File pathname) { 
                return true;
            }
         }));
    }

    public static ArrayList<File> listFiles(File dir, FileFilter filter) {
         ArrayList<File> files = new ArrayList<File>();
         listFiles(dir, files, filter);
         return files;
    }

    private static void listFiles(File dir, ArrayList<File> files, FileFilter filter) {
        if (!dir.isDirectory()) {
             return;
        }
        for (File file : dir.listFiles()) {
            if (filter.accept(file)) {
                 files.add(file);
            }
            listFiles(file, files, filter);
        }
    }
}
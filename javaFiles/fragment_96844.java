package javas;

import java.io.File;
import java.io.FilenameFilter;

public class DirectoryHtmlFiles {

public static void main(String a[]){
            int Count = 0;
    File file = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\JavaWeb");
    String[] files = file.list(new FilenameFilter() {

        @Override
        public boolean accept(File dir, String name) {
            if(name.toLowerCase().endsWith(".html")){
                return true;
            } else {
                return false;
            }
        }
    });
    for(String f:files){
                    Count++;
        System.out.println(f);
                    System.out.println(Count);
    }
}
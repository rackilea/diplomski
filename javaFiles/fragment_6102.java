import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        final String FILE_NAME = "testfile";
        /* The method listFiles returns all the files in the path 
           (I used "." to select the working directory).
           This method accept a FileFilter as parameter. The file filter
           decides what files to return. It is a simple interface with just
           one method. */
        File[] fileList = new File(".").listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                /* Return true to include the file in the list */
                return pathname.getName().startsWith(FILE_NAME);
            }
        });

        List<File> list = Arrays.asList(fileList);

        for (File f: list) {
            System.out.println(f);
        }
    }
}
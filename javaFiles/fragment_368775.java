import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileLister {

    private List<File> getFileList(File startingDir) throws FileNotFoundException {
        List<File> result = new ArrayList<File>();
        File[] filesAndDirs = startingDir.listFiles();
        List<File> filesDirs = Arrays.asList(filesAndDirs);
        for (File file : filesDirs) {
            result.add(file); 
            if (!file.isFile()) {               
                List<File> deeperList = getFileList(file);
                result.addAll(deeperList);
            }
        }

        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        for(File file : new FileLister().getFileList(new File("D:\\Music"))){
            if(file.getName().contains(".")) {
                String extension = file.getName().substring(file.getName().lastIndexOf("."), file.getName().length());
                if(extension.equalsIgnoreCase(".mp3")) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}
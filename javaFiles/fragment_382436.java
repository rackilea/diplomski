import java.io.File;

public class Files {
    public void listFiles(){
        String folderPath = "C:/Users/*****/Desktop"; // or as required
        File file = new File(folderPath);
        File[] files = file.listFiles();
        for (File fileName : files) {
            System.out.println(fileName); //Do what you need here... I'm just printing to console.
        }
    }

}
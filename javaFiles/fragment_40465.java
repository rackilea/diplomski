import java.io.File;

public class FilePathTest
{
    public static void main(String[] args)
    {
        loadObject("res/SomeFile.txt");
        loadObject("SomeFile.txt");
    }

    static File path;

    static void loadObject(String filename)
    {
        File file = new File(filename);
        path = file.getParentFile();        
        parseFile(filename);
    }

    static void parseFile(String filename)
    {
        File file = new File(path, filename);
        System.out.println("File: "+file+" exists? "+file.exists());
    }
}
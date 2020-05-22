import java.io.File;

public class FilePathTest
{
    public static void main(String[] args)
    {
        loadObject("res/", "SomeFile.obj");
    }

    static File path;

    static void loadObject(String parent, String filename)
    {
        File file = new File(parent+File.separator+filename);
        path = new File(parent);        
        parseFile(file);
    }

    static void parseFile(File file)
    {
        System.out.println("File: "+file+" exists? "+file.exists());

        String mtlName = "SomeFile.mtl";
        File mtlFile = new File(path, mtlName);

        System.out.println("MTL file: "+mtlFile+" exists? "+mtlFile.exists());
    }
}
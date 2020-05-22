import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.apache.commons.io.FileUtils;

public class App
{
  public static void main(String[] args)
  {
    try
    {

      //needed attributes
      String pathToJar = "./src/main/blablalba/fileName.jar";
      String folderYouWantToRetrieveFromTheJar = "/folderIWant";
      String pathOfFilesWithinTheJar="src/resources/blablabla/"+folderYouWantToRetrieveFromTheJar+"/";
      String tempDirectoryWhereExtract="./src/main/resources/temp";

      //creating the temp directory
      File tempDirectoryReference = new File(tempDirectoryWhereExtract);
      if (!tempDirectoryReference.exists())
      {
        Files.createDirectory(tempDirectoryReference.toPath());
      }

      //searching what entries i need
      JarFile jar = new JarFile(pathToJar);
      final Enumeration<JarEntry> entries = jar.entries(); 
      List<JarEntry> targetEntries = new ArrayList<>();
      while (entries.hasMoreElements())
      {
        JarEntry entry = entries.nextElement();
        //if the entry is what i need 
        if (entry.getName().startsWith(pathOfFilesWithinTheJar))
        { 
          targetEntries.add(entry);
        }
      }
      //extract every target entry from the .jar
      for (JarEntry entry : targetEntries)
      {
        //in order to copy the structure i will get only the point where folderIWant is present
        int index = entry.getName().indexOf(folderYouWantToRetrieveFromTheJar);
        String newTemporaryPath = tempDirectoryReference.getPath().toString()+"/"+entry.getName().substring(index);
        extractFileFromJar(jar, entry, new File(newTemporaryPath));

      }

      jar.close();
      //(optional) clean after use
      FileUtils.deleteDirectory(tempDirectoryReference);


    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void extractFileFromJar (JarFile jarFile, JarEntry targetEntry, File destinyPath)
  {
    try
    {
      if (!destinyPath.getParentFile().exists())
      {
        createFolderStructure(destinyPath);
      }
      else
      {
        Files.createFile(destinyPath.toPath());
      }

      InputStream inputStream = jarFile.getInputStream(targetEntry); 
      FileOutputStream outputStream = new java.io.FileOutputStream(destinyPath);
      while (inputStream.available() > 0) {  
          outputStream.write(inputStream.read());
      }
      outputStream.flush();
      outputStream.close();
      inputStream.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }


  private static void createFolderStructure(File destinyPath)
  {
    File parentPath = destinyPath.getParentFile();
    try
    {
      if (parentPath.exists())
      {
          Files.createFile(destinyPath.toPath());
      }
      else
      {
        Files.createDirectories(destinyPath.getParentFile().toPath());
        Files.createFile(destinyPath.toPath());
      }
    }
    catch(IOException e)
    {
      System.err.println(e.getMessage());
    }
  }
}
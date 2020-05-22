import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExample {
public static void main(String[] args) {

    FileOutputStream fop = null;
    File file;
    String content = "This is the text content";//our you can take it

    try {

        file = new File("c:/newfile.txt");//File creation at C:/
        fop = new FileOutputStream(file);

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        // get the content in bytes
        byte[] contentInBytes = content.getBytes();

        fop.write(contentInBytes);
        System.out.println("Done");

    } catch (IOException e) {
        e.printStackTrace();
      }
   finally{
      if(fop!=null){
      fop.flush();
      fop.close();
   }
}
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class OrgLogic {

String path="C:\\Users\\Fawkes\\Music\\Music\\";
String target_path="C:\\Output\\";

OrgLogic() throws IOException{
    File f=new File(path); //loads the input dir path
    File dir=new File(target_path); //loads the output dir path
    dir.mkdir();//create a new dir name output
    File[] total_file=f.listFiles();//get the total number of file
    //System.out.println(total_file.length);//prints the total number of the file
    for(int i=0;i<total_file.length;i++) {
        String name=total_file[i].getName();
        String new_name=name.substring(0, name.indexOf("-")-1);
        dir=new File(target_path+new_name);
        if(dir.exists()) {
            Path src=Paths.get(total_file[i].getPath());
            Path dest=Paths.get(dir.getAbsolutePath().concat("\\").concat(total_file[i].getName()));
            Files.copy(src, dest ,StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Files copied: "+(i+1)+"/"+total_file.length);
        }
        else {
            dir.mkdir();    
            Path src=Paths.get(total_file[i].getPath());
            Path dest=Paths.get(dir.getAbsolutePath().concat("\\").concat(total_file[i].getName()));// only needed to add this line.
            Files.copy(src, dest ,StandardCopyOption.REPLACE_EXISTING);             
            System.out.println("Files copied: "+(i+1)+"/"+total_file.length);
        }
    }   


}
public static void main(String[] args) {
    try {
        new OrgLogic();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
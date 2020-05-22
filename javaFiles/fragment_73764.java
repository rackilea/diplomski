import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenAFile2 {

public static void main(String[] args) throws IOException{

String userdir = System.getProperty("user.home");

String dirpath2 = userdir + "\\Downloads";
File fileName = getLatestFilefromDir(dirpath2);

System.out.println(fileName);    

File file = fileName;

if(!Desktop.isDesktopSupported()){
        System.out.println("Desktop is not supported");
        return;
    }

Desktop desktop = Desktop.getDesktop();
    if(file.exists()) desktop.open(file);

if(file.exists()) desktop.open(file);
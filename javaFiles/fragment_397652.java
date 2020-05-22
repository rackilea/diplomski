import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class DemoClass {

  public static void main(String[] args) {
    Logger logger = Logger.getLogger("main");
    FileAppender fileAppender = new FileAppender();
    fileAppender.setLayout(new PatternLayout("%-5p [%t]: %m%n"));
    logger.addAppender(fileAppender);
    String userLogFileName = "";
    BufferedReader  reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      userLogFileName = reader.readLine();//read the users input
    } catch (IOException e) {
      System.out.println("error on reading user input");
      e.printStackTrace();
    }
    File file = new File(userLogFileName);
    try {
      if(!file.exists()) {//if the file does not exist
        file.createNewFile();//create a new file
      }
    } catch (IOException e) {
      System.out.println("error on creating file");
      e.printStackTrace();
    }
    fileAppender.setFile(userLogFileName);//the file must exist
    fileAppender.activateOptions();//activate the new file
    logger.error("test");
  }

}
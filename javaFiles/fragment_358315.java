import javafx.application.Application;

public class Launcher{

   public static void main(String[] args){

      if(args[0] != 0){
         Application.launch(YourFXMainClass.class,args);
       }else{
         YourConsoleApplication.main(args);
      }

   }
}
import cli.System.IO.*;

public class ShowDir{

   public static void main(String[] args){
       String[] files = Directory.GetFiles("."); //.NET System.IO
       for(String file : files){
           System.out.println(file);
       }
   }
}
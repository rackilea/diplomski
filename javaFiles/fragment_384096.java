public class FileRetrieve_Easy_main 
{
   public static void main(String[] args)
   {    
       new Thread(new Server.SimpleServer()).start();
       new Thread(new Client.SimpleClient()).start();

  }
}
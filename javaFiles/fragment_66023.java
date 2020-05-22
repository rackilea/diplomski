import java.lang.* ;

public class Shell 
{
        public static void main(String[] args)
        {   
                try { 
                        String cmd = "kill 123";
                        Runtime run = Runtime.getRuntime();
                        Process pr = run.exec(cmd) ;
                } catch (Exception ex) {
                        System.out.println("SOMETHING WENT WRONG");
                }   
        }   
}
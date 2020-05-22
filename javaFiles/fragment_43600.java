public class MyLogger {
    public static void main (String args[]) throws Exception {
         System.setOut(new PrintStream("out.txt"));
         System.setErr(new PrintStream("err.txt"));
         OriginalClassName.main(args);
    }
 }
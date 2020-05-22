public class Runner{
  public static void main(String[] args) throws Exception {
  String[] cmd = { "C:\\Program Files\\MY PROGRAM.exe","PARAM1","PARAM2" };
    Runtime.getRuntime().exec(cmd);
    System.out.println("Done.");
  }
}
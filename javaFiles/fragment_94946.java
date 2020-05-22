public class Test2 {
  public static void main(String[] args) throws Exception {
    String fileName = "c:\\temp\\test.bmp";
    String [] commands = {
        "cmd.exe" , "/c", "start" , "\"DummyTitle\"", "\"" + fileName + "\""
    };
    Process p = Runtime.getRuntime().exec(commands);
    p.waitFor();
    System.out.println("Done.");
 }
}
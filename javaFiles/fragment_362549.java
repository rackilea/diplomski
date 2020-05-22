public class RuntimeFun {
   public static void main(String[] args) throws Exception {
      Runtime r = Runtime.getRuntime();
      Process p = r.exec("C:\\dev\\cygwin\\bin\\mintty.exe --version");
      p.waitFor();

      BufferedReader buf = new BufferedReader(
               new InputStreamReader(
                        p.getInputStream()));
      String line = buf.readLine();
      while (line != null) {
          System.out.println(line);
          line = buf.readLine();
      }
   }
}
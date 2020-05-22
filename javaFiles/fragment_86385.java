public class TestMain {
   private static final String BASH_CMD = "bash";

   private static final String PROG = "/home/abhishek/workspace/Pro/run";

   private static final String[] CMD_ARRAY = { BASH_CMD , PROG };

   public static void main(String[] args) {
      new Thread(new Runnable() {
         public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                  System.in));
            String command = null;
            try {
               while ((command = reader.readLine()) != null) {
                  System.out.println("Command Received:" + command);
               }
            } catch (Exception ex) {
               ex.printStackTrace();
               // failed to listening command
            }

         }
      }).start();
      Process process = null;
      try {
         ProcessBuilder processBuilder = new ProcessBuilder(CMD_ARRAY);
         process = processBuilder.start();
         InputStream inputStream = process.getInputStream();
         setUpStreamGobbler(inputStream, System.out);

         InputStream errorStream = process.getErrorStream();
         setUpStreamGobbler(errorStream, System.err);

         System.out.println("never returns");
         process.waitFor();
      } catch (IOException e) {
         throw new RuntimeException(e);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
   }

   public static void setUpStreamGobbler(final InputStream is, final PrintStream ps) {
      final InputStreamReader streamReader = new InputStreamReader(is);
      new Thread(new Runnable() {
         public void run() {
            BufferedReader br = new BufferedReader(streamReader);
            String line = null;
            try {
               while ((line = br.readLine()) != null) {
                  ps.println("process stream: " + line);
               }
            } catch (IOException e) {
               e.printStackTrace();
            } finally {
               try {
                  br.close();
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }
         }
      }).start();
   }
}
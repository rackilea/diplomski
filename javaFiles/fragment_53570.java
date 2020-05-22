public class Log {
   private MainForm mainForm; // our MainForm variable

   public Log(MainForm mainForm) {
      // setting the MainForm variable to the correct reference in its constructor
      this.mainForm = mainForm;  
   }

   private  void consoleOut(String data) {
     System.out.println(data);
     if (mainForm != null) {
        // now we can use the reference passed in.
        mainForm.setConsoleText("data");
     }
   }
}
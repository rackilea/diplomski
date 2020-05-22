public class TextEditor extends JFrame {

   int count = 2;
   JTextArea n = new JTextArea();
   final JFileChooser fc = new JFileChooser();

   public void SaveAs() {

      final JFileChooser SaveAs = new JFileChooser();
      SaveAs.setApproveButtonText("Save");
      int actionDialog = SaveAs.showOpenDialog(this);
      if (actionDialog != JFileChooser.APPROVE_OPTION) {
         return;
      }

      File fileName = new File(SaveAs.getSelectedFile() + ".txt");
      BufferedWriter outFile = null;
      try {
         outFile = new BufferedWriter(new FileWriter(fileName));

         n.write(outFile);   // *** here: ***

      } catch (IOException ex) {
         ex.printStackTrace();
      } finally {
         if (outFile != null) {
            try {
               outFile.close();
            } catch (IOException e) {
               // one of the few times that I think that it's OK
               // to leave this blank
            }
         }
      }
   }

}
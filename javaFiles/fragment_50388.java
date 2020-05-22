String sResponse;//make sResponse a field of class xyz
public String askQuestion()throws Exception
 {
    java.awt.EventQueue.invokeAndWait(new Runnable() {
        @Override
        public void run() {
            String response = JOptionPane.showInputDialog(null, "What is 2+2?");
            sResponse = response;
        }
    });
   return sResopnse;
}
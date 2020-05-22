public String askQuestion()throws Exception
   {
    final StringBuilder sBuilder = new StringBuilder();
    java.awt.EventQueue.invokeAndWait(new Runnable() {
        @Override
        public void run() {
            String response = JOptionPane.showInputDialog(null, "What is 2+2?");
            sBuilder.append(response);
        }
    });
   return sBuilder.toString();
}
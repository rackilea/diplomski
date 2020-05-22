javax.swing.SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
         try {
            new comm();  //create the user interface named window
            //window.open();             //invoke open() function
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
  });
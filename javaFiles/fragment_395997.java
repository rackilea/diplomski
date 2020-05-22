} catch (Exception ex) {
   final String exMessage = ex.getMessage();

   SwingUtilities.invokeLater(new Runnable() {
     public void run() {
       JOptionPane.showMessageDialog(
         null,
         exMessage,
         "Database Error",
         JOptionPane.ERROR_MESSAGE);
       );
     }
   });
  }
}
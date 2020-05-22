public void windowClosing (WindowEvent e) {         
   int confirm = JOptionPane.showConfirmDialog (this, "Exit game?", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

   if (confirm == JOptionPane.YES_OPTION) {
      dispose();
   }
}
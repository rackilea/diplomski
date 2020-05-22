final JScrollPane scroll = new JScrollPane(text);
javax.swing.SwingUtilities.invokeLater(new Runnable() {
   public void run() { 
       scroll.getVerticalScrollBar().setValue(0);
   }
});
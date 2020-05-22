public static void main(String args[])
{
   SwingUtilities.invokeLater(new Runnable(){
      public void run(){
         new PongMainGUI();

         Timer timer = new Timer(10, new ActionListener(){
            public void actionPerformed(ActionEvent e){
               System.out.println("PongMainGUI");
               panel.repaint();
               panel.move();
            }
         });
         timer.start();
      }
   });
}
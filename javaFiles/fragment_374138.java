ActionListener taskPerformer=new ActionListener() {
   public void actionPerformed(ActionEvent ae) {
      x++;
      y++;
      width++;
      height++;
      repaint();
   }
};
new Timer(100,taskPerformer).start();
JLabel label = new JLabel(yourIcon); // probably an ImageIcon
label.addMouseListener(new MouseAdapter(){
   public void mouseClicked(MouseEvent e) {
     System.out.println("Click at: " + e.getPoint();
   }
});
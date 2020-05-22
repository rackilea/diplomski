b1.addMouseListener(new MouseAdapter(){
   public void MouseReleased(MouseEvent e){
      p.removeAll();
      p.repaint();
      p.revalidate();
      p.add(p2);
   }
});
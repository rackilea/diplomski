frame.addMouseListener(new MouseAdapter(){

   @Override
   public void mouseClicked(MouseEvent e)
   {
       if(e.getX() == someVariable && e.getY() == anotherVariable)
       {
          do something here
       }
   }
});
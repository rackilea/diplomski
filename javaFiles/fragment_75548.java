public void update(Graphics g) 
{
     System.out.println("repaint");
     if(left)
     {
         p.goL();
         p.drawPlayer(g);
         left = false;
     }
     else if(right)
     {
         p.goR();
         p.drawPlayer(g);
         right = false;
     }
     else if(up)
     {
         p.goU();
         p.drawPlayer(g);
         up = false;
     }
     else if(down)
     {
         p.goD();
         p.drawPlayer(g);
         down = false;
     }
     else
     {
         p.drawPlayer(g);
     }

}
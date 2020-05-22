public class taskTwo extends JPanel
{ //extended JPanel so that we can over-ride the paintComponent() function in it.

//all your code for creating JFrame and adding panel to it.

//replace public void paint() with painComponent()

public void paintComponent(Graphics g)
{
  float red=rand.nextFloat();
  float green=rand.nextFloat();
  float blue=rand.nextFloat();
   Color randomColor=new Color(red,green,blue);
   g.drawOval(50,50,25,25);
    g.setColor(randomColor);
    g.fillOval(50,50,25,25);
}
}
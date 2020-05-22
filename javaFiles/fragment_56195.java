import java.awt.*;   
import java.awt.event.*;

// no window closing code
public class MouseXY extends Frame implements MouseListener, MouseMotionListener  
{
          int x , y;
          String str =" ";
          public MouseXY()  
          {
                 setSize(500, 500);
                 setVisible(true); 
                 addMouseListener(this);                // register both the listeners with frame
                 addMouseMotionListener(this);                              
           }                                            // override the 5 abstract methods of ML
           public void mouseEntered(MouseEvent e)   
           { 
                  setBackground(Color.green);
                  x = e.getX();
                  y = e.getY();
                  str ="Mouse Entered";
                  repaint();
           }                                                                   
           public void mouseExited(MouseEvent e)    
           {
                  setBackground(Color.red);
                  x = e.getX();
                  y = e.getY();
                  str ="Mouse Exited";
                  repaint();
           }
           public void mouseClicked(MouseEvent e)
           {
                  setBackground(Color.gray);
                  x = e.getX();
                  y = e.getY();
                  str ="Mouse Clicked";
                  repaint();
           }
           public void mouseReleased(MouseEvent e)   
           {
                  setBackground(Color.blue);
                  x = e.getX();
                  y = e.getY();
                  str ="Mouse Released";
                  repaint();
           }
           public void mousePressed(MouseEvent e)   
           {
               setBackground(Color.lightGray);
               x = e.getX();
               y = e.getY();
               str ="Mouse pressed";
               repaint();
          }                                                       // override the 2 abstract methods of MML
          public void mouseDragged(MouseEvent e)
          {
               setBackground(Color.magenta);
               x = e.getX(); 
               y = e.getY();
               str ="Mouse Dragged";
               repaint();
          }
          public void mouseMoved(MouseEvent e)  
          {
               setBackground(Color.yellow);
               x = e.getX();
               y = e.getY();
               str = "Mouse Moved";
               repaint();
          }
          public void paint(Graphics g)  
          {
               g.setColor(Color.blue);
               g.fillOval(x , y , 10 , 10);
               g.drawString(x +", "+ y , x , y);
               g.drawString(str , x , y -10);             // to draw the string above y coordinate
    }                              
    public static void main(String args[ ])   
    {
               new MouseXY();
    }
import javax.swing.*;
import java.awt.*;
public class myJFrame extends JFrame{
    public void paint(Graphics g) {//This method is what paints the JFrame, as its name implies.
        super.paint(g);
        int sizeX = this.getWidth()/8;//Takes the size of current JFrame
        int sizeY=this.getWidth()/12;
        for(int x=0;x<sizeX;x++)//These for loops go through an 8x12 grid of the JFrame
            for(int y=0;y<sizeY;y++) {
                g.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));//This just creates a random color, you can replace this with anything else
                g.fillRect(x*sizeX,y*sizeY,sizeX,sizeY);//Creates the grid
            }
    }
    public static void main(String[] args) {
        JFrame f=new myJFrame();//If you already have a JFrame implemented, you'll have to replace its declaration with this line of code
        //f.setUndecorated(true);//If you want evenly distributed grids, uncomment this line.
        f.setVisible(true);//Sets the JFrame to be visible
        f.setSize(80,120);//This size is arbitrary, you can replace it with anything, and the program will still work
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //If you want the grid to be perfectly distributed, then uncomment the line below.

    }
}
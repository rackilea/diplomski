import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class GalacticPanel extends JPanel implements GalacticConstants1{

    public Point point=new Point(Ship_X,Ship_Y);
    Image img;
    ImageIcon i;
    GalacticEngine1 ge;

    public void setEngine(GalacticEngine1 ge) {
        this.ge = ge;
    }
    public GalacticPanel() {

        setBackground(Color.white);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        System.out.println("Painting");

        g.setColor(Color.blue);
        //red star color
        g.drawOval(20,40,Star_Width,Star_Height);
        g.fillOval(20,40,Star_Width,Star_Height);
        //first red star
        g.drawOval(200,200,Star_Width,Star_Height);
        g.fillOval(200,200,Star_Width,Star_Height);
        //second red star
        g.drawOval(300,400,Star_Width,Star_Height);
        g.fillOval(300,400,Star_Width,Star_Height);
        //third red star
        g.drawOval(400,550,Star_Width,Star_Height);
        g.fillOval(400,550,Star_Width,Star_Height);
        //fourth red star

        g.setColor(Color.black);
        g.drawRect(0, 0, recW, recH);
        //invisible bounds


        g.drawRect(ge.getX(), Ship_Y, 20, 20);
        //the ship x and y coordinates the ship width and height arcwidth and archeight


    }

}
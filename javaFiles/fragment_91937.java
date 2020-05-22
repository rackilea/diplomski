import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JApplet;

public class Circles extends JApplet
{   
    private final List<Point> positions;
    private final List<Integer> diameters;

    public Circles()
    {
        positions = new ArrayList<Point>();
        diameters = new ArrayList<Integer>();

        Random rand = new Random();

        for(int i=1; i <= 5 ; i++ )
        {
            int tries = 10;
            for (int t=0; t<tries; t++)
            {
                int diameter = rand.nextInt(75)+1;
                int posX = rand.nextInt(500);;
                int posY = rand.nextInt(500);
                Point position = new Point(posX, posY);

                if (!overlapsOther(position, diameter))
                {
                    positions.add(new Point(posX, posY));
                    diameters.add(diameter);
                    break;
                }
            }
        }
    }

    private boolean overlapsOther(Point position, int diameter)
    {
        int radius = diameter/2;
        int centerX = position.x + radius;
        int centerY = position.y + radius;

        for (int i=0; i<positions.size(); i++)
        {
            Point otherPosition = positions.get(i);
            int otherDiameter = diameters.get(i);
            int otherRadius = otherDiameter/2;
            int otherCenterX = otherPosition.x + otherRadius;
            int otherCenterY = otherPosition.y + otherRadius;

            int dx = centerX - otherCenterX;
            int dy = centerY - otherCenterY;
            double distance = Math.hypot(dx, dy);
            if (distance < radius + otherRadius)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(Graphics g) 
    {
        super.paint(g);

        for(int i=0; i<positions.size(); i++)
        {
            int posX = positions.get(i).x;
            int posY = positions.get(i).y;
            int diameter = diameters.get(i);

            if (diameter < 25)
            {
                g.setColor(Color.YELLOW);
                g.fillOval(posX, posY,diameter,diameter);
            }

            else if(diameter > 50)
            {
                g.setColor(Color.GREEN);
                g.fillOval(posX, posY,diameter,diameter);
            }
            else
            {
                g.setColor(Color.RED);
                g.drawOval(posX, posY,diameter,diameter);
            }

            System.out.println(diameter);
        }
    }
}
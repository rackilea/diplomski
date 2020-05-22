import java.applet.Applet;
import java.awt.*;

public class myFirstAppletRun extends Applet
{
    public void paint (Graphics page)
    {
        Graphics2D g2 = (Graphics2D) page;
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(100, 0, 100, 600);
        g2.fillArc(7, 234, 115, 100, -20, 180);
    }
}
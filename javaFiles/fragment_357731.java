package adder;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import andGate.*;

@SuppressWarnings("serial")
public class AdderComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        AndGate and = new AndGate(20, 20);
        and.draw(g2);
    }
}
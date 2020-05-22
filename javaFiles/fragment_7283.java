import acm.graphics.GMath;
import acm.graphics.GPolygon;
import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

/**
* This program creates a five-pointed star every time the user clicks the mouse
* on the canvas.
*/
public class DrawStarMap extends GraphicsProgram {

    public void init() {
        addMouseListeners();
        add(new JButton("ClearN"), NORTH);
        add(new JButton("ClearW"), WEST);
        add(new JButton("ClearE"), EAST);
        add(new JButton("ClearS"), SOUTH);
        addActionListeners();
    }

    /*
    * Called whenever the user clicks the mouse.
    */
    public void mouseClicked(MouseEvent e) {
        GStar star = new GStar(STAR_SIZE);
        star.setFilled(true);
        add(star, e.getX(), e.getY());
    }

    /*
    * Removes all the graphical objects from the canvas
    */
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().startsWith("Clear")) {
            removeAll();
        }
    }

    /*
    * Private constants
    */
    private static final double STAR_SIZE = 20;

    private static class GStar extends GPolygon {
        ...  
    }
}
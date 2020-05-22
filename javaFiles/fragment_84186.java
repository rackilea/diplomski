import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 * Runs the test program
 * @author dvargo
 */
public class Main
{
    public static void main(String [] args)
    {
        //build GUI
        JFrame mainWindow = new JFrame();
        mainWindow.setSize(800,800);
        mainWindow.setLayout(new GridLayout());

        DisplayPanel graphPanel = new DisplayPanel();
        mainWindow.add(graphPanel);

        mainWindow.setVisible(true);
        graphPanel.setVisible(true);

        //create some nodes
        Node a = new Node(graphPanel, "A");
        Node b = new Node(graphPanel, "B");
        Node c = new Node(graphPanel, "C");
        Node d = new Node(graphPanel, "D");
        Node e = new Node(graphPanel, "E");
        Node f = new Node(graphPanel, "F");

        a.setVisible(true);
        b.setVisible(true);
        c.setVisible(true);
        d.setVisible(true);
        e.setVisible(true);
        f.setVisible(true);

        //add them to their locations
        graphPanel.add(a,0,0);
        graphPanel.add(b,75,100);
        graphPanel.add(c,400,300);
        graphPanel.add(d,600,600);
        graphPanel.add(e,45,600);
        graphPanel.add(f,700,300);

        //set the connections
        a.addConnection(b);
        a.addConnection(f);
        b.addConnection(d);
        b.addConnection(c);
        b.addConnection(e);
        c.addConnection(f);
        e.addConnection(d);

    }

}
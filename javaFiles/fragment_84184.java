import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * Displays the nodes and connections in the graph
 * @author dvargo
 */
public class DisplayPanel extends JPanel
{
    /**
     * Holds the nodes in the graph
     */
    List < Node > theNodes = new ArrayList();

    public DisplayPanel()
    {
        setBackground(Color.white);
        repaint();
        setLayout(null);

        //will redraw and new lines in  the nodes automatically for you
        new Thread(new Runnable()
        {
            public void run()
            {
                while (true)
                {
                    drawConnections();
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (Exception e)
                    {

                    }
                }
            }
        }).start();
    }

    /**
     * Adds a node to the graph
     * @param newNode The node to add
     * @param xPosition The x Position in the graph to add it
     * @param yPosition The y Position in the graph to add it
     */
    public void add(Node newNode, int xPosition, int yPosition)
    {
        add(newNode);
        newNode.setLocation(xPosition, yPosition);
        theNodes.add(newNode);
    }

    /**
     * Draw the connecting lines between nodes
     */
    public void drawConnections()
    {
        Graphics g = getGraphics();
        for (Node currNode : theNodes)
        {
            for (Node currConnectedNode : currNode.getConnections())
            {
                g.drawLine(currNode.getLocation().x,
                           currNode.getLocation().y,
                           currConnectedNode.getLocation().x,
                           currConnectedNode.getLocation().y);
            }
        }
    }
}
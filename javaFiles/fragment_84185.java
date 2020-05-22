import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Represents a node in the graph
 * @author dvargo
 */
public class Node extends JPanel
{
    /**
     * Holds all the nodes this node is connected too
     */
    List < Node > connections;

    /**
     * Displays the name of this node
     */
    JLabel nameLabel;

    /**
     * Reference to the panel that is displaying these nodes
     */
    DisplayPanel displayPanel;

    /**
     * Default constructor
     * @param nodeName The name of this node
     */
    public Node(final DisplayPanel displayPanel, String nodeName)
    {
        setBackground(Color.red);
        this.displayPanel = displayPanel;
        nameLabel = new JLabel(nodeName);
        nameLabel.setVisible(true);
        add(nameLabel);
        connections = new ArrayList();

        //makes the nodes draggable
        addMouseMotionListener(new MouseMotionAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                setLocation(e.getX() + getLocation().x,
                        e.getY() + getLocation().y);
                displayPanel.repaint();
            }
        });

        setSize(50,50);
        repaint();
    }

    /**
     * Change the name of the node
     * @param newName The new name of the node
     */
    public void setName(String newName)
    {
        nameLabel.setText(newName);
    }

    /**
     * Get all the nodes this node is connected to
     * @return List of nodes this node is connected too
     */
    public List < Node > getConnections()
    {
        return connections;
    }

    /**
     * Sets a connection between this node and another node
     * @param newConnection The node to connect this node too
     */
    public void addConnection(Node newConnection)
    {
        connections.add(newConnection);
        //make sure the other node knows about this connection
        if(newConnection.getConnections().contains(this) == false)
        {
            newConnection.addConnection(this);
        }
    }

    /**
     * Removes a connection with another node
     * @param nodeToRemoveConnectionWith The nodes whose connection you could like
     * to break
     */
    public void removeConnection(Node nodeToRemoveConnectionWith)
    {
        connections.remove(nodeToRemoveConnectionWith);
    }

}
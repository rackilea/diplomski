import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;


public class ScrollContainer extends JPanel
    implements ActionListener, ComponentListener
{
    private Container container;
    private List<Component> removedComponents = new ArrayList<Component>();
    private JButton forwardButton;
    private JButton backwardButton;

    public ScrollContainer(Container container)
    {
        this.container = container;
        setLayout( new BorderLayout(5, 0) );
        addComponentListener( this );

        //  Create buttons to control scrolling

        backwardButton = new BasicArrowButton( BasicArrowButton.WEST );
        configureButton( backwardButton );
        forwardButton = new BasicArrowButton( BasicArrowButton.EAST);
        configureButton( forwardButton );

        //  Layout the panel

        add( backwardButton, BorderLayout.WEST );
        add( container );
        add( forwardButton, BorderLayout.EAST );
    }

    //  Implement the ComponentListener

    public void componentResized(ComponentEvent e)
    {
        //  When all components cannot be shown, add the forward button

        int freeSpace = getSize().width - container.getPreferredSize().width;

        if (backwardButton.isVisible())
            freeSpace -= backwardButton.getPreferredSize().width;

        forwardButton.setVisible( freeSpace < 0 );

        //  We have free space, redisplay removed components

        while (freeSpace > 0 && ! removedComponents.isEmpty())
        {
            if (removedComponents.size() == 1)
                freeSpace += backwardButton.getPreferredSize().width;

            Object o = removedComponents.get(removedComponents.size() - 1);
            Component c = (Component)o;
            freeSpace -= c.getSize().width;

            if (freeSpace >= 0)
            {
                container.add(c, 0);
                removedComponents.remove(removedComponents.size() - 1);
            }
        }

        //  Some components still not shown, add the backward button

        backwardButton.setVisible( !removedComponents.isEmpty() );

//      repaint();

    }

    public void componentMoved(ComponentEvent e) {}
    public void componentShown(ComponentEvent e) {}
    public void componentHidden(ComponentEvent e) {}

    //  Implement the ActionListener

    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        //  Scroll the components in the container

        if (source == forwardButton)
            scrollForward();
        else
            scrollBackward();
    }

    /*
     *  Simulate scrolling forward
     *  by remove the first component from the container
     */
    private void scrollForward()
    {
        if (container.getComponentCount() == 1)
            return;

        //  Remove and save the first component

        Component c = container.getComponent(0);
        container.remove( c );
        removedComponents.add( c );

        //  Allow for backwards scrolling

        backwardButton.setVisible( true );

        //  All components are showing, hide the forward button

        int backwardButtonWidth = backwardButton.getPreferredSize().width;
        int containerWidth = container.getPreferredSize().width;
        int panelWidth = getSize().width;

        if (backwardButtonWidth + containerWidth <= panelWidth)
            forwardButton.setVisible( false );

        //  Force a repaint of the panel

        revalidate();
        repaint();
    }

    /*
     *  Simulate scrolling backward
     *  by adding a removed component back to the container
     */
    private void scrollBackward()
    {
        if (removedComponents.isEmpty())
            return;

        //  Add a removed component back to the container

        Object o = removedComponents.remove(removedComponents.size() - 1);
        Component c = (Component)o;
        container.add(c, 0);

        //  Display scroll buttons when necessary

        if (removedComponents.isEmpty())
            backwardButton.setVisible( false );

        forwardButton.setVisible( true );
        revalidate();
        repaint();
    }

    private void configureButton(JButton button)
    {
        button.setVisible( false );
        button.addActionListener( this );
    }

    private static void createAndShowGUI()
    {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.add( new JButton("one") );
        toolBar.add( new JButton("two222222") );
        toolBar.add( new JButton("three") );
        toolBar.add( new JButton("four") );
        toolBar.add( new JButton("five") );
        toolBar.add( new JButton("six666666666") );
        toolBar.add( new JButton("seven") );
        toolBar.add( new JButton("eight") );
        toolBar.add( new JButton("nine9999999") );
        toolBar.add( new JButton("ten") );
        ScrollContainer container = new ScrollContainer(toolBar);

        JFrame frame = new JFrame("Scroll Container");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(container, BorderLayout.NORTH);
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DescendantHierarchyListening extends JPanel
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.add(new DescendantHierarchyListening());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    ContainerListener containerListener = new ContainerListener()
    {
        @Override
        public void componentAdded(ContainerEvent e)
        {
            Component child = e.getChild();
            System.out.println("Added   " + child);
            System.out.println("   to   " + e.getContainer());

            if (child instanceof Container)
            {
                Container container = (Container)child;
                container.addContainerListener(this);
            }
        }

        @Override
        public void componentRemoved(ContainerEvent e)
        {
            Component child = e.getChild();
            System.out.println("Removed " + child);
            System.out.println("   from " + e.getContainer());
            if (child instanceof Container)
            {
                Container container = (Container)child;
                container.removeContainerListener(this);
            }
        }
    };

    private final JPanel root;
    public JPanel leafComponent;

    public DescendantHierarchyListening()
    {
        super(new BorderLayout());

        JButton button = createAddChildButton();
        add(button, BorderLayout.NORTH);

        root = createChildPanel(null);
        root.addContainerListener(containerListener);

        add(root, BorderLayout.CENTER);
        leafComponent = root;
    }

    private JButton createAddChildButton()
    {
        JButton button = new JButton("AddChild");
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JPanel child = createChildPanel(leafComponent);
                leafComponent.add(child);
                leafComponent = child;
                revalidate();
            }
        });
        return button;
    }

    public JPanel createChildPanel(final Container parent)
    {
        JPanel panel = new JPanel(new BorderLayout())
        {
            @Override
            public String toString()
            {
                return "Child of " + parent;
            }
        };
        Color color = getColor(parent);
        panel.setBorder(BorderFactory.createLineBorder(color, 2));
        return panel;
    }

    private static Color getColor(Component c)
    {
        if (c == null)
        {
            return Color.GREEN;
        }
        Color[] colors = new Color[]
        { Color.RED, Color.BLUE, Color.GREEN };
        int d = getDepth(c);
        return colors[d % colors.length];
    }

    private static int getDepth(Component c)
    {
        if (c == null)
        {
            return 0;
        }
        return 1 + getDepth(c.getParent());
    }

}
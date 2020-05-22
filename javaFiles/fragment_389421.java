import java.awt.*;
import java.util.*;
import javax.swing.*;

public class TopFlowLayout extends FlowLayout
{
    @Override
    public void layoutContainer(Container container)
    {
        super.layoutContainer(container);

        Component c = container.getComponent(0);

        int lineStart = getVgap();
        int lineHeight = lineStart + c.getSize().height;

        for (int i = 0; i < container.getComponentCount(); i++)
        {
            c = container.getComponent(i);

            Point p = c.getLocation();
            Dimension d = c.getSize();

            if (p.y < lineHeight) // still on current line
            {
                p.y = lineStart;
                lineHeight = Math.max(lineHeight, lineStart + d.height);
            }
            else  // start a new line
            {
                lineStart = lineHeight + getVgap();
                p.y = lineStart;
                lineHeight = lineStart + d.height;
            }

            p.y = lineStart;
            c.setLocation(p);
        }
    }

    private static void createAndShowGUI()
    {
        TopFlowLayout layout = new TopFlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        JPanel flowPanel = new JPanel( layout );

        Random random = new Random();

        for (int i = 0; i < 10; i++)
        {
            flowPanel.add( createButton(i + "", random.nextInt(100), random.nextInt(100)) );
        }

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( flowPanel );
        frame.setLocationByPlatform( true );
        frame.setSize(400, 400);
        frame.setVisible( true );
    }

    private static JButton createButton(String text, int width, int height)
    {
        JButton button = new JButton(text);
        Dimension size = new Dimension(width + 50, height + 50);
        button.setPreferredSize(size);

        return button;
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
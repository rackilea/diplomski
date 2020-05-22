import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

public class ScrollPaneSSCCE extends JPanel
{
    public ScrollPaneSSCCE()
    {
        setLayout( new BorderLayout() );

        JTextArea textArea = new JTextArea(1, 80);
        textArea.setText("Hopefully this will answer your question");
        JScrollPane scrollPane = new JScrollPane( textArea );
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);

        JScrollBar horizontal = scrollPane.getHorizontalScrollBar();

        BasicArrowButton west = new BasicArrowButton(BasicArrowButton.WEST);
        west.setAction( new ActionMapAction("", horizontal, "negativeUnitIncrement") );
        add(west, BorderLayout.WEST);

        BasicArrowButton east = new BasicArrowButton(BasicArrowButton.EAST);
        east.setAction( new ActionMapAction("", horizontal, "positiveUnitIncrement") );
        add(east, BorderLayout.EAST);
    }

    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("ScrollPaneSSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ScrollPaneSSCCE(), BorderLayout.NORTH);
        frame.setSize(100, 100);
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class TabbedPaneWithComponent
{
    private static void createAndShowUI()
    {
        JPanel panel = new JPanel();
        panel.setLayout( new OverlayLayout(panel) );

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("1", new JTextField("one"));
        tabbedPane.add("2", new JTextField("two"));
        tabbedPane.setAlignmentX(1.0f);
        tabbedPane.setAlignmentY(0.0f);

        JCheckBox checkBox = new JCheckBox("Check Me");
        checkBox.setOpaque( false );
        checkBox.setAlignmentX(1.0f);
        checkBox.setAlignmentY(0.0f);

        panel.add( checkBox );
        panel.add(tabbedPane);

        JFrame frame = new JFrame("TabbedPane With Component");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( panel );
        frame.setLocationByPlatform( true );
        frame.setSize(400, 100);
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
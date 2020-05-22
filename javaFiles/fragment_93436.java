import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TestContainer extends JFrame {

private JPanel contentPane;
public static JTabbedPane tabbedPane1;

/**
 * Launch the application.
 */
public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            try {
                TestContainer frame = new TestContainer();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

/**
 * Create the frame.
 */
public TestContainer() {

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JScrollPane scrollBasePane = new JScrollPane();
    scrollBasePane.setBounds(10, 11, 414, 239);
    contentPane.add(scrollBasePane);

    JPanel panelBase = new JPanel();
    scrollBasePane.setViewportView(panelBase);
    panelBase.setLayout(null);

    tabbedPane1 = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane1.setBounds(10, 11, 392, 215);
    panelBase.add(tabbedPane1);

    // add new JPanel to TabbedPane via a reusable Class
    MoreTabs mt1 = new MoreTabs("Label 1");
    MoreTabs mt2 = new MoreTabs("Label 2");
    MoreTabs mt3 = new MoreTabs("Label 3");

    tabbedPane1.addTab( "More Tabs 1", mt1); //non-static
    tabbedPane1.addTab( "More Tabs 2", mt2); //non-static
    tabbedPane1.addTab( "More Tabs 3", mt3); //non-static
    }
}
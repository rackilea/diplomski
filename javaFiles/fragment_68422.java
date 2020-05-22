import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class Test {
    private static final int USER_INPUT = 10;

    public Test() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);


        JTabbedPane tabs = new JTabbedPane();
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        for (int i = 0; i < 5; i++) {
            tabs.addTab("Tab"+i, new TabPanel());
        }

        frame.add(tabs);
        frame.pack();
        frame.setVisible(true);
    }

    class TabPanel extends JPanel {    
        public TabPanel() {
            JPanel innerPanel = new JPanel();
            innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));

            for (int i = 0; i < USER_INPUT; i++) {
                JPanel p = new JPanel(new BorderLayout());
                JLabel label = new JLabel("Label"+i);
                JTextField textArea = new JTextField();
                p.add(label, BorderLayout.NORTH);
                p.add(textArea, BorderLayout.CENTER);
                innerPanel.add(p);
            }

            JScrollPane scrollPane = new JScrollPane(innerPanel);
            scrollPane.setPreferredSize(new Dimension(400, 200));
            this.add(scrollPane);
        }
    }

    public static void main(String[] args) {
        new Test();
    }
}
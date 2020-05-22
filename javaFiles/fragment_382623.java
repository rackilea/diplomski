import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TestFrame extends JFrame {

    public static void main(String... s) {
        new TestFrame();
    }

    private JTabbedPane tabs;

    public TestFrame() {
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        tabs = new JTabbedPane();

        tabs.addTab("1", new Tab(1));
        tabs.addTab("2", new Tab(2));
        tabs.addTab("3", new Tab(3));
        add(tabs);
    }

    private class Tab extends JPanel {

        public Tab(int i) {
            JButton next = new JButton("next");
            next.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedIndex = tabs.getSelectedIndex();
                    int nextIndex = selectedIndex == tabs.getTabCount()-1 ? 0 : selectedIndex+1;
                    tabs.setSelectedIndex(nextIndex);
                }
            });
            add(new JLabel("tab " + i));
            add(next);
        }
    }

}
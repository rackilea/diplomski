import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPaneExample {

    private JFrame frame = new JFrame();

    public TabbedPaneExample() {
        JButton btn = new JButton("Test");

        JPanel panel = new JPanel();
        panel.add(btn);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Tab1", panel);

        frame.add(tabbedPane, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setMinimumSize(new Dimension(300, 300));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TabbedPaneExample main = new TabbedPaneExample();
    }
}
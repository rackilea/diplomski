import java.awt.*;
import javax.swing.*;

public class TestTabbedScroll {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                JPanel panel = new JPanel();
                Box box = Box.createVerticalBox();
                for (int i = 0; i < 100; i++) {
                    box.add(new JLabel("Hello, StackOverflow!"));
                }
                panel.add(box);
                panel.setBackground(Color.CYAN);

                JTabbedPane tab = new JTabbedPane();
                JScrollPane scroll = new JScrollPane(panel);
                scroll.setPreferredSize(new Dimension(300, 300));
                tab.add(scroll, "Panel 1");

                JOptionPane.showMessageDialog(
                        null, tab, "Test Tabbed", JOptionPane.PLAIN_MESSAGE); 
            }
        });
    }
}
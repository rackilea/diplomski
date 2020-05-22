import java.awt.EventQueue;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class TabExample {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            final JFrame frame = new JFrame("Example");
            final JTabbedPane tp = new JTabbedPane();
            final BurgerTab burgerTab = new BurgerTab();
            final JScrollPane scrollPane = new JScrollPane(burgerTab, 
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            tp.addTab("Burgers", scrollPane);
            frame.getContentPane().add(tp);
            frame.pack();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
        });
    }

    private static class BurgerTab extends JPanel {

        BurgerTab() {
            setLayout(new BoxLayout(this, SwingConstants.VERTICAL));
            final JPanel[] burgers = new JPanel[40];

            for(int i = 0; i < burgers.length; i++) {
                burgers[i] = new JPanel();
                burgers[i].add(new JLabel("Burger #" + (i + 1)));
                add(burgers[i]);
            }
        }

    }

}
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                JMenuBar menu = new JMenuBar();

                //creating new JMenuItem
                JMenuItem m1 = new JMenuItem("File");
                JMenuItem m2 = new JMenuItem("Exit");

                menu.add(m1);
                menu.add(m2);

                JFrame frame = new JFrame("Testing");
                frame.setJMenuBar(menu);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setBorder(new EmptyBorder(10, 10, 10, 10));
            setLayout(new GridLayout(2, 2, 10, 10));
            add(makeButton("Unit"));
            add(makeButton("Information"));
            add(makeButton("Search"));
            add(makeButton("Exit"));
        }

        protected JButton makeButton(String text) {
            JButton btn = new JButton(text);
            btn.setMargin(new Insets(10, 10, 10, 10));
            return btn;
        }

    }

}
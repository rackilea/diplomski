import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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

                JFrame frame = new JFrame("Testing");
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
            setLayout(new GridBagLayout());
            try {
                add(createButton());
                add(createButton());
                add(createButton());
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }

        protected JToggleButton createButton() throws IOException {

            JToggleButton btn = new JToggleButton();
            btn.setModel(new StickyModel());
            btn.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/Blank.png"))));
            btn.setSelectedIcon(new ImageIcon(ImageIO.read(getClass().getResource("/Bomb.png"))));
            return btn;

        }

    }

    public class StickyModel extends JToggleButton.ToggleButtonModel {

        public void reset() {
            super.setSelected(false);
        }

        @Override
        public void setSelected(boolean b) {
            if (!isSelected()) {
                super.setSelected(b);
            }
        }

    }

}
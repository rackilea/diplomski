import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PopupMenuTest {

    public static void main(String[] args) {
        new PopupMenuTest();
    }

    public PopupMenuTest() {
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

        private JPopupMenu popupMenu;

        public TestPane() {
            popupMenu = new JPopupMenu();
            popupMenu.add(new JMenuItem("Open..."));
            popupMenu.add(new JMenuItem("Save..."));
            popupMenu.add(new JMenuItem("Close..."));
            popupMenu.add(new JMenuItem("Give Blood..."));
            popupMenu.add(new JMenuItem("Give Money..."));

            addMouseListener(new MouseAdapter() {

                protected void doPopup(MouseEvent evt) {
                    if (evt.isPopupTrigger()) {
                        popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
                    }
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    doPopup(e);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    doPopup(e);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    doPopup(e);
                }

            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class OverlayButton {

    public static void main(String[] args) {
        new OverlayButton();
    }

    public OverlayButton() {
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

        private JScrollPane sp;
        private JButton btn;
        private JTextArea ta;

        private JPanel glassPane;

        public TestPane() {
            setLayout(new BorderLayout());
            btn = new JButton("Print");
            ta = new JTextArea(10, 20);

            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(new File("Script.txt")));
                String text = null;
                while ((text = br.readLine()) != null) {
                    ta.append(text + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }

            ta.setCaretPosition(0);
            sp = new JScrollPane(ta);
            glassPane = new JPanel() {

                @Override
                public void doLayout() {
                    Point p = sp.getLocation();
                    Dimension dim = sp.getSize();
                    p = SwingUtilities.convertPoint(sp, p, this);

                    btn.setSize(btn.getPreferredSize());
                    int barWidth = sp.getVerticalScrollBar().getWidth();
                    int barHeight = sp.getHorizontalScrollBar().getHeight();
                    int x = p.x + (dim.width - btn.getWidth()) - barWidth;
                    int y = p.y + (dim.height - btn.getHeight()) - barHeight;
                    btn.setLocation(x, y);
                }

            };
            glassPane.setOpaque(false);
            glassPane.add(btn);
            glassPane.addComponentListener(new ComponentAdapter() {

                @Override
                public void componentResized(ComponentEvent e) {
                    e.getComponent().doLayout();
                }

            });
            add(sp);
        }

        @Override
        public void addNotify() {
            super.addNotify();
            SwingUtilities.getRootPane(this).setGlassPane(glassPane);
            glassPane.setVisible(true);
            glassPane.revalidate();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.dispose();
        }

    }

}
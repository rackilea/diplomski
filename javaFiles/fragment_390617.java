import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
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

        private Map<String, Boolean> mapKeys;

        public TestPane() {
            mapKeys = new HashMap<>();
            mapKeys.put("A", false);
            mapKeys.put("S", false);
            mapKeys.put("D", false);
            mapKeys.put(" ", false);
            mapKeys.put("J", false);
            mapKeys.put("K", false);
            mapKeys.put("L", false);

            bindKey(KeyEvent.VK_A, "A");
            bindKey(KeyEvent.VK_S, "S");
            bindKey(KeyEvent.VK_D, "D");
            bindKey(KeyEvent.VK_SPACE, " ");
            bindKey(KeyEvent.VK_J, "J");
            bindKey(KeyEvent.VK_K, "K");
            bindKey(KeyEvent.VK_L, "L");
        }

        protected void bindKey(int keyCode, String name) {

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(keyCode, 0, false), "pressed." + name);
            im.put(KeyStroke.getKeyStroke(keyCode, 0, true), "released." + name);

            am.put("pressed." + name, new KeyAction(name, true));
            am.put("released." + name, new KeyAction(name, false));

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            FontMetrics fm = g2d.getFontMetrics();
            int charWidth = fm.charWidth('M') + 2;
            int charHeight = fm.getHeight();
            int x = (getWidth() - ((charWidth + 2) * mapKeys.size())) / 2;
            int y = (getHeight() - charHeight) / 2;
            for (String name : mapKeys.keySet()) {
                boolean state = mapKeys.get(name);
                int xPos = x + ((charWidth - fm.stringWidth(name))) / 2;
                Rectangle bounds = new Rectangle(x, y, charWidth, charHeight);
                if (state) {
                    g2d.setColor(Color.RED);
                    g2d.fill(bounds);
                }
                g2d.setColor(Color.BLACK);
                g2d.draw(bounds);
                g2d.drawString(name, xPos, y + fm.getAscent());
                x += charWidth + 2;
            }
            g2d.dispose();
        }

        public class KeyAction extends AbstractAction {

            private String name;
            private boolean state;

            public KeyAction(String name, boolean state) {
                this.name = name;
                this.state = state;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                mapKeys.put(name, state);
                repaint();
            }

        }

    }

}
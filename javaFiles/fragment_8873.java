import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class DragMe {

    public static void main(String[] args) {
        new DragMe();
    }

    public DragMe() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JTextArea ta = new JTextArea(10, 20);
                ta.setText("Bananas in pajamas");
                JScrollPane sp = new JScrollPane(ta);

                DragProxyPane proxy = new DragProxyPane(sp);
                proxy.setSize(proxy.getPreferredSize());
                proxy.setLocation(100 - proxy.getWidth() / 2, 100 - proxy.getHeight()/ 2);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new JPanel() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(300, 300);
                    }
                });
                frame.add(proxy);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class DragProxyPane extends JPanel {

        public static final int BUFFER_ZONE = 10;

        private boolean mouseInHouse;
        private JComponent component;

        private List<HotZone> hotZones;

        public DragProxyPane(JComponent comp) {
            MouseAdapter ma = new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    mouseInHouse = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    mouseInHouse = false;
                    repaint();
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    Cursor cursor = Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
                    for (HotZone hz : hotZones) {
                        if (hz.getBounds(getSize()).contains(e.getPoint())) {
                            cursor = hz.getCursor();
                            break;
                        }
                    }
                    setCursor(cursor);
                }

            };

            addMouseListener(ma);
            addMouseMotionListener(ma);

            setOpaque(false);
            setLayout(new BorderLayout());
            add(comp);

            setBorder(new EmptyBorder(BUFFER_ZONE, BUFFER_ZONE, BUFFER_ZONE, BUFFER_ZONE));

            hotZones = new ArrayList<>(8);
            // Top left, middle, right
            hotZones.add(new HotZone(0f, 0f, Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR)));
            hotZones.add(new HotZone(0.5f, 0f, Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR)));
            hotZones.add(new HotZone(1f, 0f, Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR)));
            // Left, right
            hotZones.add(new HotZone(0f, 0.5f, Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR)));
            hotZones.add(new HotZone(1f, 0.5f, Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR)));
            // Bottom left, middle, right
            hotZones.add(new HotZone(0f, 1f, Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR)));
            hotZones.add(new HotZone(0.5f, 1f, Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR)));
            hotZones.add(new HotZone(1f, 1f, Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR)));

        }


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (mouseInHouse) {
                g2d.setColor(Color.BLACK);
                for (HotZone hotZone : hotZones) {
                    g2d.draw(hotZone.getBounds(getSize()));
                }
            }
            g2d.dispose();
        }

        public class HotZone {

            private float x, y;
            private Cursor cursor;

            public HotZone(float x, float y, Cursor cursor) {
                this.x = x;
                this.y = y;
                this.cursor = cursor;
            }

            public Cursor getCursor() {
                return cursor;
            }

            public Rectangle getBounds(Dimension size) {

                return getBounds(size.width - 1, size.height - 1);

            }

            public Rectangle getBounds(int width, int height) {

                int halfBuffer = BUFFER_ZONE / 2;

                float xPos = (width * x) - halfBuffer;
                float yPos = (height * y) - halfBuffer;

                xPos = Math.min(Math.max(0, xPos), width - BUFFER_ZONE);
                yPos = Math.min(Math.max(0, yPos), height - BUFFER_ZONE);

                return new Rectangle(Math.round(xPos), Math.round(yPos), BUFFER_ZONE, BUFFER_ZONE);

            }

        }

    }

}
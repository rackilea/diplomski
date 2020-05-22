import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JViewport;
import javax.swing.Scrollable;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(new SpriteEditorSpane());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public class SpriteEditorSpane extends JPanel {

        private JLabel sprite;
        private JSlider zoom;
        private EditorPane editorPane;

        public SpriteEditorSpane() throws IOException {
            setLayout(new GridBagLayout());

            BufferedImage source = ImageIO.read(new File("sprites/Doctor-01.png"));
            sprite = new JLabel(new ImageIcon(source));

            editorPane = new EditorPane();
            editorPane.setSource(source);

            zoom = new JSlider(2, 10);
            zoom.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    editorPane.setGridSize(zoom.getValue());
                }
            });
            zoom.setValue(2);
            zoom.setPaintTicks(true);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridheight = GridBagConstraints.REMAINDER;
            add(sprite, gbc);

            gbc.gridx++;
            gbc.gridheight = 1;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1;
            gbc.weighty = 1;
            add(new JScrollPane(editorPane), gbc);

            gbc.gridy++;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1;
            gbc.weighty = 0;
            add(zoom, gbc);

        }

    }

    public class EditorPane extends JPanel implements Scrollable {

        private BufferedImage source;
        private BufferedImage gridBuffer;

        private int gridSize = 2;
        private Color gridColor;

        private Timer updateTimer;

        public EditorPane() {
            updateTimer = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    doBufferUpdate();
                    revalidate();
                    repaint();
                }
            });
            updateTimer.setRepeats(false);
            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    updateBuffer();
                }
            });
            setGridColor(new Color(128, 128, 128, 128));
            setToolTipText("Sprite");
        }

        @Override
        public Dimension getPreferredSize() {
            return source == null ? new Dimension(200, 200)
                    : new Dimension(source.getWidth() * gridSize, source.getHeight() * gridSize);
        }

        public void setGridColor(Color color) {
            if (color != gridColor) {
                this.gridColor = color;
                updateBuffer();
            }
        }

        public Color getGridColor() {
            return gridColor;
        }

        public void setSource(BufferedImage image) {
            if (image != source) {
                this.source = image;
                updateBuffer();
            }
        }

        public void setGridSize(int size) {
            if (size != gridSize) {
                this.gridSize = size;
                updateBuffer();
            }
        }

        public BufferedImage getSource() {
            return source;
        }

        public int getGridSize() {
            return gridSize;
        }

        @Override
        public String getToolTipText(MouseEvent event) {
            Point p = event.getPoint();
            int x = p.x / getGridSize();
            int y = p.y / getGridSize();

            BufferedImage source = getSource();
            String tip = null;
            if (x < source.getWidth() && y < source.getHeight()) {

                Color pixel = new Color(source.getRGB(x, y), true);
                StringBuilder sb = new StringBuilder(128);
                sb.append("<html><table><tr><td>");
                sb.append("R:").append(pixel.getRed());
                sb.append(" G:").append(pixel.getGreen());
                sb.append(" B:").append(pixel.getBlue());
                sb.append(" A:").append(pixel.getAlpha());
                String hex = String.format("#%02x%02x%02x%02x", pixel.getRed(), pixel.getGreen(), pixel.getBlue(), pixel.getAlpha());
                sb.append("</td></tr><tr><td bgcolor=").append(hex);
                sb.append("width=20 height=20>&nbsp;</td></tr></table>");

                tip = sb.toString();

            }

            return tip;
        }

        @Override
        public Point getToolTipLocation(MouseEvent event) {
            Point p = new Point(event.getPoint());
            p.x += 8;
            p.y += 8;
            return p;
        }

        protected void doBufferUpdate() {
            BufferedImage source = getSource();
            int gridSize = getGridSize();
            gridBuffer = null;
            if (source != null) {
                gridBuffer = new BufferedImage(source.getWidth() * gridSize, source.getHeight() * gridSize, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = gridBuffer.createGraphics();
                for (int row = 0; row < source.getHeight(); row++) {
                    for (int col = 0; col < source.getWidth(); col++) {
                        int xPos = col * gridSize;
                        int yPos = row * gridSize;
                        Color pixel = new Color(source.getRGB(col, row), true);
                        g2d.setColor(pixel);
                        g2d.fillRect(xPos, yPos, gridSize, gridSize);
                        g2d.setColor(getGridColor());
                        g2d.drawRect(xPos, yPos, gridSize, gridSize);
                    }
                }
                g2d.dispose();
            } else if (getWidth() > 0 && getHeight() > 0) {
                gridBuffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = gridBuffer.createGraphics();
                g2d.setColor(gridColor);
                for (int xPos = 0; xPos < getWidth(); xPos += gridSize) {
                    g2d.drawLine(xPos, 0, xPos, getHeight());
                }
                for (int yPos = 0; yPos < getHeight(); yPos += gridSize) {
                    g2d.drawLine(0, yPos, getWidth(), yPos);
                }
                g2d.dispose();
            }
        }

        protected void updateBuffer() {
            updateTimer.restart();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (gridBuffer != null) {
                g2d.drawImage(gridBuffer, 0, 0, this);
            }
            g2d.dispose();
        }

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return new Dimension(200, 200);
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 128;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 128;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            Container parent = getParent();
            return parent instanceof JViewport
                    && parent.getWidth() > getPreferredSize().width;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            Container parent = getParent();
            return parent instanceof JViewport
                    && parent.getHeight() > getPreferredSize().height;
        }

    }
}
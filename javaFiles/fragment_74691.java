import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GlassPaneDemo {
        private static BufferedImage bi;

        public static void main(String[] args){
            try {
                loadImages();

                SwingUtilities.invokeLater(new Runnable(){
                    @Override
                    public void run() {
                        createAndShowGUI();             
                    }
                });
            } catch (IOException e) {
                // handle exception
            }
        }

        private static void loadImages() throws IOException{
            bi = ImageIO.read(new File("src/resources/person.png"));
        }

        private static void createAndShowGUI(){
            final JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setGlassPane(new CustomGlassPane());
            frame.getContentPane().add(getButtonPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.getGlassPane().setVisible(true);
            frame.setVisible(true);
        }

        private static final JPanel getButtonPanel(){
            @SuppressWarnings("serial")
            final JPanel panel = new JPanel(){
                @Override
                protected void paintComponent(Graphics g){
                    Graphics gCopy = g.create();

                    gCopy.setColor(Color.BLUE.darker());
                    gCopy.fillRect(0, 0, getWidth(), getHeight());

                    gCopy.dispose();
                }
            };

            final JLabel labelOne = new JLabel();
            labelOne.setIcon(new ImageIcon(bi));
            final JLabel labelTwo = new JLabel();
            labelTwo.setIcon(new ImageIcon(bi));
            panel.add(labelOne);
            panel.add(labelTwo);

            return panel;
        }

        @SuppressWarnings("serial")
        private static class CustomGlassPane extends JComponent{
            private Point p1;
            private Point p2;
            private boolean lineDrawn;

            public CustomGlassPane(){
                addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e){
                        if(p1 == null || lineDrawn){
                            if(lineDrawn){
                                p1 = null;
                                p2 = null;
                                lineDrawn = false;
                            }
                            p1 = e.getPoint();
                        }else{
                            p2 = e.getPoint();
                            repaint(); // not optimal
                            lineDrawn = true;
                        }
                    }
                });

                // Block all other input events
                addMouseMotionListener(new MouseMotionAdapter(){});
                addKeyListener(new KeyAdapter(){});
                addComponentListener(new ComponentAdapter(){
                    @Override
                    public void componentShown(ComponentEvent e){
                        requestFocusInWindow();
                    }
                });
                setFocusTraversalKeysEnabled(false);
            }

            @Override
            protected void paintComponent(Graphics g){
                if(p1 != null && p2 != null){
                    Graphics2D g2 = (Graphics2D) g.create();

                    g2.setRenderingHint(
                            RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(Color.RED);
                    g2.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());

                    g2.dispose();
                }
            }
        }
  }
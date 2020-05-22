import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {

    private JFrame frame = new JFrame("");
    private Rectangles rect00 = new Rectangles(0, 0, 129, 129);
    private Rectangles rect01 = new Rectangles(136, 0, 129, 129);
    private Rectangles rect02 = new Rectangles(268, 0, 129, 129);
    private Rectangles rect10 = new Rectangles(0, 136, 129, 129);
    private Rectangles rect11 = new Rectangles(134, 136, 129, 129);
    private Rectangles rect12 = new Rectangles(269, 137, 129, 129);
    private Rectangles rect20 = new Rectangles(0, 270, 129, 129);
    private Rectangles rect21 = new Rectangles(136, 269, 129, 129);
    private Rectangles rect22 = new Rectangles(269, 270, 129, 129);

    public void Display() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(600, 400);
        sub inter = new sub();
        inter.setLayout(null);
        inter.setBounds(0, 0, 600, 400);
        inter.setSize(600, 400);

        rect00.setBounds(rect00.getX(), rect00.getY(), rect00.getWidth(), rect00.getHeight());
        rect01.setBounds(rect01.getX(), rect01.getY(), rect01.getWidth(), rect01.getHeight());
        rect02.setBounds(rect02.getX(), rect02.getY(), rect02.getWidth(), rect02.getHeight());
        rect10.setBounds(rect10.getX(), rect10.getY(), rect10.getWidth(), rect10.getHeight());
        rect11.setBounds(rect11.getX(), rect11.getY(), rect11.getWidth(), rect11.getHeight());
        rect12.setBounds(rect12.getX(), rect12.getY(), rect12.getWidth(), rect12.getHeight());
        rect20.setBounds(rect20.getX(), rect20.getY(), rect20.getWidth(), rect20.getHeight());
        rect21.setBounds(rect21.getX(), rect21.getY(), rect21.getWidth(), rect21.getHeight());
        rect22.setBounds(rect22.getX(), rect22.getY(), rect22.getWidth(), rect22.getHeight());
        rect00.setOpaque(false);
        rect01.setOpaque(false);
        rect02.setOpaque(false);
        rect10.setOpaque(false);
        rect11.setOpaque(false);
        rect12.setOpaque(false);
        rect20.setOpaque(false);
        rect21.setOpaque(false);
        rect22.setOpaque(false);

        inter.addPanel(rect00);
        inter.addPanel(rect01);
        inter.addPanel(rect02);
        inter.addPanel(rect10);
        inter.addPanel(rect11);
        inter.addPanel(rect12);
        inter.addPanel(rect20);
        inter.addPanel(rect21);
        inter.addPanel(rect22);
        frame.add(inter);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new Test().Display();
    }

    private class sub extends JPanel {

        private BufferedImage image;
        private ArrayList<Rectangles> rects = new ArrayList<>();

        public sub() {

            try {
                image = ImageIO.read(new File("c:/image.png"));

            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return (new Dimension(600, 400));
        }

        void addPanel(Rectangles r) {
            rects.add(r);
            add(r);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Rectangles r : rects) {
                g.drawImage(image, r.getX(), r.getY(), null);
            }
        }
    }
}

class Rectangles extends JPanel implements MouseListener {

    private int Posx;
    private int Posy;
    private int width;
    private int height;
    private boolean selected = false;

    public Rectangles(int Posx, int Posy, int width, int height) {
        this.Posx = Posx;
        this.Posy = Posy;
        this.width = width;
        this.height = height;
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (selected == true) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(250, 235, 215));
            g2.drawRect(0,0, width, height);
            g2.setColor(new Color(0, 0, 0));
            g2.setStroke(new BasicStroke(20));
            g2.drawLine(0,0, width,height);
            g2.drawLine(getWidth(),0, 0, height);
        }

    }

    public int getX() {
        return Posx;
    }

    public int getY() {
        return Posy;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setSelected() {
        selected = true;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        selected = true;
        repaint();


    }
}
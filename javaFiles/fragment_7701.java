//canvas object
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Screen extends Canvas {

    Rectangle ball;
    Vector<Rectangle> rects = new Vector<Rectangle>();
    int x = 1;
    int y = -1;

    private BufferedImage buffer;
    private Rectangle temp;

    public Screen() {
        ball = new Rectangle(10, 38, 30, 30);

        MouseAdapter ma = new MouseAdapter() {

            private Point anchor;

            public void mouseClicked(MouseEvent e) {
                Point p = new Point(e.getX(), e.getY());
                checkRemove(p);
            }

            public void mousePressed(MouseEvent e) {
                anchor = new Point(e.getPoint());
            }

            public void mouseReleased(MouseEvent e) {
                anchor = null;
                if (temp != null) {
                    addOne(temp);
                }
                temp = null;
                repaint();
            }

            public void mouseDragged(MouseEvent e) {
                Point p = e.getPoint();
                int minX = Math.min(anchor.x, p.x);
                int minY = Math.min(anchor.y, p.y);
                int maxX = Math.max(anchor.x, p.x);
                int maxY = Math.max(anchor.y, p.y);

                temp = new Rectangle(minX, minY, maxX - minX, maxY - minY);
                repaint();
            }
        };
        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    public int ballX() {
        return ball.x;
    }

    public int ballY() {
        return ball.y;
    }

    public void addOne(Rectangle r) {
        Rectangle nr = new Rectangle(r);
        if (!nr.intersects(ball)) {
            if (nr.x + nr.width > getWidth() - 1) {
                nr.setSize((getWidth() - 1) - nr.x, nr.height);
            }
            if (nr.y + nr.height > getHeight() - 1) {
                nr.setSize(nr.width, (getHeight() - 1) - nr.y);
            }
            rects.addElement(nr);
        }
        setMinimumSize(calculateMinimumSize());
        constraintsChanged();
    }

    public void checkRemove(Point p) {
        Point np = new Point(p);
        for (int i = 0; i < rects.size(); i++) {
            if (rects.get(i).contains(np)) {
                rects.removeElementAt(i);
                i--;
            }
        }
        setMinimumSize(calculateMinimumSize());
        constraintsChanged();
    }

    public void step() {
        checkBorder();
        checkTouching();
        repaint();
    }

    public void checkBorder() {
        Rectangle tempBall = new Rectangle(ball);
        tempBall.grow(2, 2);
        Rectangle screen = new Rectangle(new Point(0, 0), getSize());
        if (screen.contains(tempBall)) {
            ball.setLocation((int) ball.getX() + x, (int) ball.getY() + y);
        } else {
            if (ball.x + ball.width > screen.width - 3) {
                x = -1;
            }
            if (ball.y + ball.height > screen.height - 3) {
                y = -1;
            }
            if (ball.x < screen.x + 2) {
                x = 1;
            }
            if (ball.y < screen.y + 2) {
                y = 1;
            }
            ball.setLocation(ball.x + x, ball.y + y);
        }
    }

    public void checkTouching() {
        if (temp != null) {
            rects.add(temp);
        }
        for (int i = 0; i < rects.size(); i++) {
            Rectangle b = new Rectangle(ball);
            b.grow(1, 1);
            if (rects.get(i).intersects(b)) {
                int left = rects.get(i).x;
                int top = rects.get(i).y;
                int right = rects.get(i).x + rects.get(i).width;
                int bottom = rects.get(i).y + rects.get(i).height;
                if ((b.x + b.width) > left) {
                    x = x * -1;
                } else if ((b.x < right)) {
                    x = x * -1;
                } else if ((b.y + b.height) > top) {
                    y = y * -1;
                } else if (b.y < bottom) {
                    y = y * -1;
                }
            }
        }
        if (temp != null) {
            rects.remove(temp);
        }
    }

    public void setObjSize(int size) {
        ball.setSize(size, size);
    }

    @Override
    public void invalidate() {
        super.invalidate(); 
        buffer = null;
        resized();
    }

    public void resized() {
        if (ball.x + ball.width > getWidth() - 3) {
            ball.setLocation(getWidth() - ball.width - 3, ball.y);
        }
        if (ball.y + ball.height > getHeight() - 3) {
            ball.setLocation(ball.x, getHeight() - ball.height - 3);
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        super.paint(g2d);
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.BLACK);
        if (temp != null) {
            g2d.fill(temp);
        }
        for (Rectangle drawRect : this.rects) {
            g2d.fill(drawRect);
        }

        //draw the screen border
        g2d.setColor(Color.RED);
        g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        //draw the ball
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillOval(ball.x, ball.y, ball.width, ball.height);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(ball.x, ball.y, ball.width, ball.height);
        g2d.dispose();
    }

    @Override
    public void update(Graphics g) {
        if (buffer == null) {
            buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D g2d = buffer.createGraphics();
        super.update(g2d);
        g2d.dispose();
        g.drawImage(buffer, 0, 0, null);
    }

    protected Dimension calculateMinimumSize() {
        Area area = new Area();
        for (Rectangle temp : this.rects) {
            System.out.println(temp);
            area.add(new Area(temp));
        }
        Rectangle bounds = area.getBounds();
        System.out.println("bounds = " + bounds);
        Dimension size = new Dimension(bounds.x + bounds.width, bounds.y + bounds.height);
        return size;
    }

    public interface ConstraintListener {
        public void constraintsChanged(Dimension size);
    }

    private ConstraintListener listener;

    public void setConstraintListener(ConstraintListener listener) {
        this.listener = listener;
    }

    protected void constraintsChanged() {
        if (listener == null) {
            return;
        }
        listener.constraintsChanged(getMinimumSize());
    }
}
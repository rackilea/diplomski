public class MmmuhApplet extends JApplet {
    int x, y;

    public void inti() {
        addMouseListener(new MouseProcessing(MmmuhApplet.this));
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class MouseProcessing implements MouseListener {
    private MmmuhApplet mmmuh;

    public MouseProcessing(MmmuhApplet mmmuh) {
        this.mmmuh = mmmuh;
    }

    public void mousePressed(MouseEvent e) {
        Point p = e.getPoint();
        mmmuh.setX(p.x);
        mmmuh.setY(p.y);
    }
}
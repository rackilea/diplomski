public class CarPark extends JPanel {

private final Rectangle[] rects;

static class Rectangle {
    int x,y,w,h;

    public Rectangle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

}

public CarPark(){
    rects = new Rectangle[]{
        new Rectangle(25, 35, 30, 80),
        new Rectangle(50, 35, 30, 80)
    };

}

@Override
public void paintComponent(Graphics g){
    super.paintComponent(g);
    this.setBackground(Color.white);

    for (Rectangle rect : rects) {
        g.fillRect(rect.x, rect.h, rect.w, rect.h);
    }

}
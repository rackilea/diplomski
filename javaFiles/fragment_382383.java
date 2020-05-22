import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Quadrat extends Canvas {

    public int x;
    public int y;
    public int status;

    private int totalX;
    private int totalY;

    public boolean isRed;
    public boolean isBlue;

    public Quadrat(int x, int y, int totalX, int totalY, boolean isRed, boolean isBlue, int status) {
        this.x = x;
        this.y = y;
        this.totalX = totalX;
        this.totalY = totalY;
        this.isRed = isRed;
        this.isBlue = isBlue;
        this.status = status;
    }

    public void paint(Graphics g) {
        if (isRed) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLUE);
        }

        g.fillRect(x, y, totalX, totalY);
    }
}
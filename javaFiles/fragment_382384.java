import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class MainCanvas extends Canvas {

    private Quadrat quadrat;

    private int AMPLE = 10;
    private int GRUIX = 300;
    private int ALTURA = 300;

    public MainCanvas() {
        quadrat = new Quadrat(0, 0, 100, 100, true, false, 0);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(AMPLE / 3, 0, GRUIX, ALTURA);
        g.fillRect((AMPLE / 3) * 2, 0, GRUIX, ALTURA);
        g.fillRect(0, ALTURA / 3, AMPLE, GRUIX);
        g.fillRect(0, (ALTURA / 3) * 2, AMPLE, GRUIX);

        quadrat.paint(g);
    }

}
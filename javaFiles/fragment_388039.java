import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class Main extends JFrame {;

    public Main(int n) {
        setSize(900, 900);
        setTitle("Pythagoras tree");
        add(new Draw(n));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Give amount of steps: ");
        new Main(sc.nextInt());
    }
}

class Draw extends JComponent {
    private int height = 800;
    private int width = 800;
    private int steps;

    public Draw(int n) {
        steps = n;

        Dimension d = new Dimension(width, height);
        setMinimumSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.black);

        int x1, x2, x3, y1, y2, y3;
        int base = width/7;

        x1 = (width/2)-(base/2);
        x2 = (width/2)+(base/2);
        x3 = width/2;
        y1 = (height-(height/15))-base;
        y2 = height-(height/15);
        y3 = (height-(height/15))-(base+(base/2));

        //paint
        g.drawPolygon(new int[]{x1, x1, x2, x2, x1}, new int[]{y1, y2, y2, y1, y1}, 5);

        int n1 = steps;
        if(--n1 > 0){
            g.drawPolygon(new int[] {x1, x3, x2}, new int[] {y1, y3, y1}, 3);
            paintMore(n1, g, x1, x3, x2, y1, y3, y1);
            paintMore(n1, g, x2, x3, x1, y1, y3, y1);
        }
    }

    public void paintMore(int n1, Graphics g, double x1_1, double x2_1, double x3_1, double y1_1, double y2_1, double y3_1){
        double x1, x2, x3, y1, y2, y3;
        //counting
        x1 = x1_1 + (x2_1-x3_1);
        x2 = x2_1 + (x2_1-x3_1);
        x3 = ((x2_1 + (x2_1-x3_1)) + ((x2_1-x3_1)/2)) + ((x1_1-x2_1)/2);
        y1 = y1_1 + (y2_1-y3_1);
        y2 = y2_1 + (y2_1-y3_1);
        y3 = ((y1_1 + (y2_1-y3_1)) + ((y2_1-y1_1)/2)) + ((y2_1-y3_1)/2);

        //paint
        g.setColor(Color.green);
        g.drawPolygon(new int[] {(int)x1, (int)x2, (int)x2_1, (int)x1},
                      new int[] {(int)y1, (int)y2, (int)y2_1, (int)y1}, 4);

        g.drawLine((int)x1, (int)y1, (int)x1_1, (int)y1_1);
        g.drawLine((int)x2_1, (int)y2_1, (int)x2, (int)y2);
        g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);

        if(--n1 > 0){
            g.drawLine((int)x1, (int)y1, (int)x3, (int)y3);
            g.drawLine((int)x2, (int)y2, (int)x3, (int)y3);
            paintMore(n1, g, x1, x3, x2, y1, y3, y2);
            paintMore(n1, g, x2, x3, x1, y2, y3, y1);
        }
    }
}
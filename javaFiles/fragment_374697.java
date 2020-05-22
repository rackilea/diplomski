import java.awt.*;
import javax.swing.*;

class PlotGraph {
    public static void main(String[] args) {
        JFrame win;

        win = new JFrame("testing");
        win.setSize(300, 200);
        win.setLocation(100, 100);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
        win.setContentPane(new MyComponent());
    }

}

class MyComponent extends JComponent {

    @Override
    public void paintComponent(Graphics g) {
        g.drawRect(10, 30, 50, 50);
    }
}
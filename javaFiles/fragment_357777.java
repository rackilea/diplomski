import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Main2 extends JPanel implements ActionListener {

    private static Square mySquare;
    private static Circle myCircle;
    private static Color myColor;
    private JToggleButton buttonSquare;
    private JToggleButton buttonCircle;
    JFrame frame;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (buttonSquare.isSelected()) {
            g.setColor(myColor);
            g.fillRect(mySquare.x, mySquare.y, mySquare.width, mySquare.length);
        } 
        if (buttonCircle.isSelected()) {
            g.setColor(myColor);
            g.fillOval(myCircle.x, myCircle.y, myCircle.width, myCircle.length);
        }
    }

    public Main2() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonSquare = new JToggleButton("■");
        buttonCircle = new JToggleButton("●");

        buttonCircle.addActionListener(this);
        buttonSquare.addActionListener(this);

        this.add(buttonCircle);
        this.add(buttonSquare);
        frame.add(this);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] args) {
        mySquare = new Square(30, 50, 50, 50);
        myCircle = new Circle(60, 100, 50, 50);
        myColor = Color.red;
        new Main2();
    }
}

class MyShape {
    public int x, y, width, length;

    public MyShape(int x, int y, int width, int length) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
    }

}
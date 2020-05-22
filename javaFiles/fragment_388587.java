import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Game extends JFrame {

    public Game() {
        setSize(250, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLayeredPane lp = getLayeredPane();
        //assign layout manager. otherwise you need to set content
        //bounds (not recommended)
        lp.setLayout(new BorderLayout());
        Painter painter = new Painter();
        lp.add(painter,1);
    }

    public static void main(String[] args) {
        Game frame = new Game();
        frame.setVisible(true);;
    }
}

class Painter extends JPanel {

    @Override
    protected void paintComponent(Graphics g) { //do not override paint
        super.paintComponent(g);
        g.drawString("Working",50,50);
    }
}
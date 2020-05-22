import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustomComponent extends JFrame {

    private static final long serialVersionUID = 1L;

    public CustomComponent() {
        setTitle("Custom Component Graphics2D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display() {
        add(new CustomComponents());//
        pack();
        // enforces the minimum size of both frame and component
        setMinimumSize(getSize());
        setVisible(true);
    }

    public static void main(String[] args) {
        CustomComponent main = new CustomComponent();
        main.display();
    }
}

class CustomComponents extends JPanel {

    private static final long serialVersionUID = 1L;

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(100, 100);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }

    @Override
    public void paintComponent(Graphics g) {
        int margin = 10;
        Dimension dim = getSize();
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
    }
}
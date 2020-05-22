import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Example extends JPanel {
    ArrayList<ExampleComponent> components;

    public Example() {
        components = new ArrayList<ExampleComponent>();
    }


    public void addComponent(ExampleComponent j) {
        components.add(j);
        add(j);
    }

    public static void main(String[] args) {
        JFrame app = new JFrame("Staff Prototype");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Example s = new Example();
        s.setLayout(null);
        app.getContentPane().add(s);
        s.addComponent(s.new ExampleComponent(new Rectangle(0,0,25,25)));
        s.addComponent(s.new ExampleComponent(new Rectangle(45,45,25,25)));
        app.pack();
        app.setVisible(true);
    }

    class ExampleComponent extends JPanel implements MouseMotionListener {

        public ExampleComponent(Rectangle bounds) {
            URL resource = getClass().getResource("3_disc.png");
            ImageIcon icon = new ImageIcon(resource);
            add(new JLabel(icon));
            addMouseMotionListener(this);
            setBounds(bounds);
        }

        public void mouseMoved(MouseEvent m) {
            System.out.println("Mouse Moved");
        }

        public void mouseDragged(MouseEvent m) {
            System.out.println("Mouse Dragged");
        }
    }
}
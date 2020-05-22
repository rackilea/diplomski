import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ScrollPaneRepaintDemo extends JPanel {
    public ScrollPaneRepaintDemo() {
        setPreferredSize(new Dimension(2000,2000));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(new ScrollPaneRepaintDemo()));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override protected void paintComponent(Graphics g) {
        Rectangle clip = g.getClipBounds();
        g.setColor(new Color(new Random().nextInt()));
        g.fillRect(clip.x, clip.y, clip.width, clip.height);
    }
}
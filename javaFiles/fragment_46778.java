import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* @see https://stackoverflow.com/a/10970892/230513
*/
public class ColorWheel extends JPanel {

    private static final int N = 32;
    private final Queue<Color> clut = new LinkedList<Color>();
    private final JLabel label = new JLabel();

    public ColorWheel() {
        for (int i = 0; i < N; i++) {
            clut.add(Color.getHSBColor((float) i / N, 1, 1));
        }
        this.setBackground(clut.peek());
        label.setText(getBackground().toString());
        this.add(label);
        this.addMouseWheelListener(new MouseAdapter() {

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                setBackground(clut.peek());
                label.setText(getBackground().toString());
                clut.add(clut.remove());
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(320, 240);
    }

    private void display() {
        JFrame f = new JFrame("ColorWheel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ColorWheel().display();
            }
        });
    }
}
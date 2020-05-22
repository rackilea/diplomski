import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class Display2 extends JPanel {
    private int prefW;
    private int prefH;

    public Display2(int prefW, int prefH) {
        this.prefW = prefW;
        this.prefH = prefH;
        MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
        addMouseListener(myMouseAdapter);
        addMouseMotionListener(myMouseAdapter);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(prefW, prefH);
    }

    private static void createAndShowGui() {
        Display2 mainPanel = new Display2(500, 500);

        JFrame frame = new JFrame("Display");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

class MyMouseAdapter extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.printf("Mouse Pressed at: %s%n", e.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.printf("Mouse Released at: %s%n", e.getPoint());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.printf("Mouse Dragged at: %s%n", e.getPoint());
    }
}
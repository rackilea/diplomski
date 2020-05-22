import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        SnapFrame frame = new SnapFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}

class SnapFrame extends JFrame implements ComponentListener {

    Dimension screenSize;

    public SnapFrame() {
        super();
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        addComponentListener(this);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        Rectangle r = getBounds();

        if (r.getMinY()==0  || r.getMaxY()==(int)screenSize.getHeight()) {
            System.out.print("Well snap!");
        }
    }

    @Override
    public void componentMoved(ComponentEvent ignore) {}

    @Override
    public void componentShown(ComponentEvent ignore) {}

    @Override
    public void componentHidden(ComponentEvent ignore) {}
}
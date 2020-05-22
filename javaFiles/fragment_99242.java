import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FullHeightWindow extends JFrame implements MouseListener {

    public FullHeightWindow() {
        super("FullHeightWindow");
        setSize(100, 10000);
        addMouseListener(this);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FullHeightWindow());
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        setAlwaysOnTop(true);
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }


    @Override
    public void mouseExited(MouseEvent e) {
        setAlwaysOnTop(false);
    }
}
import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

private MainCanvas mainCanvas;

public static void main(String[] args) {
    MyPanel myPanel = new MyPanel();

    JFrame frame = new JFrame("Main");
    frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH); // maximize window
    frame.setLayout(new BorderLayout());
    frame.add(myPanel, BorderLayout.CENTER);
    frame.setVisible(true);
}

public MyPanel() {
    mainCanvas = new MainCanvas();
}

@Override
protected void paintComponent(Graphics g) {
    mainCanvas.paint(g);
}
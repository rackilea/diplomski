import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class Grafin2 extends JPanel {
    private static final int PREF_W = 920;
    private static final int PREF_H = 580;
    private static final Dimension TOOLS_SIZE = new Dimension(250, PREF_H);
    private static final Dimension CANVAS_SIZE = new Dimension(1500, 1000);
    private JPanel toolsPanel = new JPanel();
    private CanvasPanel canvasPanel = new CanvasPanel();

    public Grafin2() {
        MyBox box1 = new MyBox(10, 200, 30, 128);
        MyBox box2 = new MyBox(200, 10, 120, 40);

        box1.changeFillColor(new Color(255, 120, 120));
        box2.changeFillColor(new Color(220, 220, 255));

        canvasPanel.addMyBox(box1);
        canvasPanel.addMyBox(box2);

        toolsPanel.setPreferredSize(TOOLS_SIZE);
        canvasPanel.setBackground(Color.white);
        canvasPanel.setPreferredSize(CANVAS_SIZE);
        JScrollPane canvasScroll = new JScrollPane(canvasPanel);

        setLayout(new BorderLayout());
        add(toolsPanel, BorderLayout.LINE_START);
        add(canvasScroll, BorderLayout.CENTER);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class CanvasPanel extends JPanel {
        // a collection to hold all the boxes
        private List<MyBox> boxes = new ArrayList<>();

        public void addMyBox(MyBox myBox) {
            boxes.add(myBox);
        }

        @Override // again, this is the proper painting method
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // never forget this!
            for (MyBox myBox : boxes) {
                myBox.draw(g); // draw all the boxes that we hold
            }
        }
    }

    private static void createAndShowGui() {
        Grafin2 mainPanel = new Grafin2();

        JFrame frame = new JFrame("Grafin2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

// this is a logical class, **not** a component class.
class MyBox {
    private Color borderColor;
    private Color fillColor;
    public int x;
    public int y;
    public int width;
    public int height;

    public MyBox() {
        borderColor = Color.black;
        fillColor = new Color(242, 242, 242);
        x = y = 1;
        width = height = 30;
    }

    public MyBox(int px, int py, int w, int h) {
        x = px;
        y = py;
        borderColor = Color.black;
        fillColor = new Color(242, 242, 242);
        width = w;
        height = h;
    }

    public void changeFillColor(Color c) {
        fillColor = c;
    }

    public void changeBorderColor(Color c) {
        borderColor = c;
    }

    public void draw(Graphics g) {
        // no need to call a super method
        // because there is none for this class
        g.setColor(fillColor);
        g.fillRect(x, y, width, height);
        g.setColor(borderColor);
        g.drawRect(x, y, width, height);
    }
}
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class FocusTest extends JPanel {

    private static final int ROWS = 6;
    private static final int COLS = 10;
    protected static final int THICKNESS = 5;
    private static final int PREF_W = 500;
    private static final int PREF_H = 300;
    private static final Color SELECTED_COLOR = Color.RED;
    private static final Color UNSELECTED_COLOR = Color.LIGHT_GRAY;

    public FocusTest() {
        setLayout(new GridLayout(ROWS, COLS, 2, 2));
        MyMouse myMouse = new MyMouse();
        MyFocus myFocus = new MyFocus();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                String text = String.format("[%d, %d]", j, i);
                final JLabel label = new JLabel(text, SwingConstants.CENTER);
                label.setBorder(createBorder(false));
                label.addFocusListener(myFocus);
                label.addMouseListener(myMouse);
                label.setFocusable(true);
                add(label);
            }
        }
    }

    public Border createBorder(boolean selected) {
        Color color = selected ? SELECTED_COLOR : UNSELECTED_COLOR;
        return BorderFactory.createLineBorder(color, THICKNESS);
    }

    private class MyMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            JComponent comp = (JComponent) e.getSource();
            comp.requestFocusInWindow();
        }
    }

    private class MyFocus extends FocusAdapter {

        @Override
        public void focusGained(FocusEvent e) {
            JComponent comp = (JComponent) e.getSource();
            comp.setBorder(createBorder(true));
        }

        @Override
        public void focusLost(FocusEvent e) {
            JComponent comp = (JComponent) e.getSource();
            comp.setBorder(createBorder(false));
        }
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension superSize = super.getPreferredSize();
        if (isPreferredSizeSet()) {
            return superSize;
        }
        int w = Math.max(PREF_W, superSize.width);
        int h = Math.max(PREF_H, superSize.height);
        return new Dimension(w, h);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("FocusTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new FocusTest());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}
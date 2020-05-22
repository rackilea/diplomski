import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestBoxLayout {

    public TestBoxLayout() {
        Box box = Box.createVerticalBox();
        for (int i = 1; i < 4; i++) {
            JPanel panel = new JPanel() {
                @Override
                public Dimension getMaximumSize() {
                    return getPreferredSize();
                }
            };
            JLabel label1 = new JLabel("Label");
            JLabel label2 = new JLabel(String.valueOf(i));
            panel.add(label1);
            panel.add(label2);
            box.add(panel);

        }

        JFrame frame = new JFrame();
        frame.add(box);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TestBoxLayout();
    }
}
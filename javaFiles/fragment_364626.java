import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class ColorButtons2 extends JPanel {

    public ColorButtons2() {
        int ebGap = 80;
        setBorder(BorderFactory.createEmptyBorder(ebGap, ebGap, ebGap, ebGap));
        setLayout(new GridLayout(1, 0, ebGap/2, 0));
        add(new JButton(new ColorAction("Red", Color.RED)));
        add(new JButton(new ColorAction("Yellow", Color.YELLOW)));
        add(new JButton(new ColorAction("Blue", Color.BLUE)));
        add(new JButton(new ColorAction("Green", Color.GREEN)));
    }

    private class ColorAction extends AbstractAction {
        private Color color;

        public ColorAction(String name, Color color) {
            super(name);
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setBackground(color);
        }
    }

    private static void createAndShowGui() {
        ColorButtons2 mainPanel = new ColorButtons2();

        JFrame frame = new JFrame("ColorButtons2");
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
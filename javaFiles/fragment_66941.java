import java.awt.*;
import javax.swing.*;

public class Example extends JFrame {

    public Example() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Box box = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 50; i++) {
            box.add(new JButton("Button " + i));
        }
        JScrollPane sp = new JScrollPane(box);
        Dimension d = new Dimension(box.getComponent(0).getPreferredSize());
        sp.getVerticalScrollBar().setUnitIncrement(d.height);
        d.height *= 10; // Show at least 10 buttons
        sp.getViewport().setPreferredSize(d);

        add(sp, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Example e = new Example();
            }
        });
    }
}
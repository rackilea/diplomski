import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvisiblePanels {
    public static void main(String... args) throws Exception {
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        frame.add(new MyPanel(), c);
        c.gridx = 1;
        frame.add(new MyPanel(), c);
        c.gridx = 2;
        frame.add(new MyPanel(), c);

        frame.pack();
        frame.setVisible(true);

    }

    private static class MyPanel extends JPanel {

        CardLayout layout;

        public MyPanel() {
            layout = new CardLayout();
            setLayout(layout);
            JButton button = new JButton("Click me");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    hidePanel();
                }
            });
            add(button, "visible");
            add(new JPanel(), "invisible");
            layout.show(this, "visible");
        }

        public void hidePanel() {
//            setVisible(false);
            layout.show(this, "invisible");
        }
    }
}
import java.awt.*;
import javax.swing.*;

/**
 * @see https://stackoverflow.com/a/20085489/230513
 */
public class TestViewer {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new ButtonPanel(), BorderLayout.LINE_END);
                frame.pack();
                frame.setSize(500, 300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private static class ButtonPanel extends Box {

        public ButtonPanel() {
            super(BoxLayout.Y_AXIS);
            this.add(createButton("Button 1"));
            this.add(createButton("Button 2"));
            this.add(createButton("Long Button 3"));
            this.add(createButton("Button 4"));
            this.add(createButton("Button 5"));
        }

        private JButton createButton(String name) {
            final JButton b = new JButton(name) {

                @Override
                public Dimension getMaximumSize() {
                    return new Dimension(
                        Short.MAX_VALUE, getPreferredSize().height);
                }
            };
            b.setAlignmentX(0.5f);
            return b;
        }
    }
}
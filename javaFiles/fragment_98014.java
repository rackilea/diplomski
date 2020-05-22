import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Example {

    private final JFrame frame;

    public Example() {
        frame = new JFrame();
        frame.setTitle("Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//app exited when frame closes
        frame.setResizable(false);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        JPanel navigation_panel_wrap = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(250, 700);
            }
        };
        JPanel content_panel_wrap = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(750, 700);
            }
        };

        content_panel_wrap.setBackground(Color.green);
        navigation_panel_wrap.setBackground(Color.red);

        frame.add(navigation_panel_wrap);
        frame.add(content_panel_wrap);
        //pack frame (size components to preferred size)
        frame.pack();
        frame.setVisible(true);//make frame visible
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }
}
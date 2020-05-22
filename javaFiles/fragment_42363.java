import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        JPanel centerWrapper = new JPanel();        

        JPanel center = new JPanel();
        center.setBackground(Color.BLUE);

        JPanel right = new JPanel();
        right.setBackground(Color.CYAN);
        right.setPreferredSize(new Dimension(200, 10));

        centerWrapper.setLayout(new BorderLayout());
        centerWrapper.add(center, BorderLayout.CENTER);
        centerWrapper.add(right, BorderLayout.EAST);

        JPanel bottom = new JPanel();        
        bottom.setPreferredSize(new Dimension(640, 200));
        bottom.setBackground(Color.GREEN);

        frame.setLayout(new BorderLayout());
        frame.add(centerWrapper, BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.SOUTH);

        // you can now use center, right and bottom

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
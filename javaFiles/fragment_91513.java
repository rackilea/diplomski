import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static MainFrame frame;

    private MainFrame() {
        this.setTitle("Focus on JTabbedPane");
        this.setSize(new Dimension(800, 600));

        this.getContentPane().add(initComponents());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private JPanel initComponents() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(new MyInfoPanel(), BorderLayout.NORTH);
        panel.add(new MyTabPanel(), BorderLayout.CENTER);

        return panel;
    }

    public static void createAndShowGui() {
        frame = new MainFrame();
        frame.setVisible(true);
    }



}
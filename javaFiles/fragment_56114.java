package demo;

     import java.awt.EventQueue;
     import java.io.File;
     import java.io.IOException;

     import javax.imageio.ImageIO;
     import javax.swing.ImageIcon;
     import javax.swing.JButton;
     import javax.swing.JFrame;
     import javax.swing.JLabel;
     import javax.swing.JPanel;
     import javax.swing.SwingUtilities;
     import javax.swing.UIManager;
     import javax.swing.border.EmptyBorder;

public class demoframe extends JFrame {

/**
 * 
 */
private static final long serialVersionUID = 1436190962490331120L;

/**
 * Launch the application.
 */
public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                demoframe frame = new demoframe();

                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                SwingUtilities.updateComponentTreeUI(frame);

                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

/**
 * Create the frame.
 */
public demoframe() {

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 988, 678);
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JPanel panel = new JPanel();
    panel.setBounds(10, 11, 501, 361);
    contentPane.add(panel);
    panel.setLayout(null);

    JButton btnNewButton = new JButton("New button");
    btnNewButton.setBounds(322, 112, 89, 23);
    panel.add(btnNewButton);

    JButton button = new JButton("New button");
    button.setBounds(322, 172, 89, 23);
    panel.add(button);

    JButton button_1 = new JButton("New button");
    button_1.setBounds(322, 244, 89, 23);
    panel.add(button_1);

    JLabel backgroundLabel;
    try {
        backgroundLabel = new JLabel(new ImageIcon(ImageIO.read(new File("images/nature.jpg"))));
        backgroundLabel.setBounds(0, 0, 501, 361);
        panel.add(backgroundLabel);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }



    JPanel panel_1 = new JPanel();
    panel_1.setBounds(521, 11, 441, 361);
    contentPane.add(panel_1);

    JPanel panel_2 = new JPanel();
    panel_2.setBounds(10, 383, 952, 246);
    contentPane.add(panel_2);

}   
 }
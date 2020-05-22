import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class mgfinancewindow {
    private JFrame frame;
    public JProgressBar progressBar;
    public JLabel lblNewLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mgfinancewindow window = new mgfinancewindow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public mgfinancewindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("MG Finances");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1362, 705);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.DARK_GRAY);
        panel_1.setBounds(0, 646, 1362, 59);
        panel.add(panel_1);
        panel_1.setLayout(null);

        lblNewLabel = new JLabel("Loading...");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(1139, 0, 114, 34);
        panel_1.add(lblNewLabel);

        progressBar = new JProgressBar();
        progressBar.setBackground(new Color(0, 51, 51));
        progressBar.setBounds(0, 34, 1362, 14);
        panel_1.add(progressBar);

        JLabel lblMgFinance = new JLabel("MG Finance");
        lblMgFinance.setHorizontalAlignment(SwingConstants.CENTER);
        lblMgFinance.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        lblMgFinance.setForeground(Color.BLUE);
        lblMgFinance.setBounds(0, 11, 1362, 635);
        panel.add(lblMgFinance);

        frame.setVisible(true);
    }

}
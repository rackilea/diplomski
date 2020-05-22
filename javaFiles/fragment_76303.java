import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new MainFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public MainFrame() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel gridbagPanel = new JPanel();
        this.setLayout(new BorderLayout());

        gridbagPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JLabel nameLabel = new JLabel("Bebras");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        mainPanel.add(nameLabel, BorderLayout.NORTH);

        JLabel money = new JLabel("Pinigai: " + new Integer(66484).toString());
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.insets = new Insets(2, 0, 0, 2);
        gridbagPanel.add(money, gc);

        JLabel job = new JLabel("Darbas: " + new Integer(126).toString());
        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(2, 0, 0, 2);
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.weightx = 1;
        gc.weighty = 1;
        gridbagPanel.add(job, gc);

        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.add(gridbagPanel, BorderLayout.WEST);

        add(mainPanel);
        getContentPane().revalidate();

    }
}
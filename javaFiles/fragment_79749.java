import java.awt.Color;


public class ProportionalPanels extends JFrame {

private JPanel contentPane;

/**
 * Create the frame.
 */
public ProportionalPanels() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
    setContentPane(contentPane);
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

    final JPanel panel_A = new JPanel();
    panel_A.setBackground(new Color(255, 165, 0));
    contentPane.add(panel_A);

    final JPanel panel_B = new JPanel();
    panel_B.setBackground(new Color(176, 196, 222));
    contentPane.add(panel_B);

    panel_A.setMinimumSize(new Dimension(0, 0));
    panel_B.setMinimumSize(new Dimension(0, 0));

    panel_A.setPreferredSize(new Dimension(0, 0));
    panel_B.setPreferredSize(new Dimension(0, 0));

    panel_A.setMaximumSize(new Dimension(Short.MAX_VALUE / 5, Short.MAX_VALUE));
    panel_B.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));

    addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            System.out.printf("Panel width rate: %.2f %n",
                    panel_B.getSize().width / (double) panel_A.getSize().width);
        }
    });
}

/**
 * Launch the application.
 */
public static void main(String[] args) {
    ProportionalPanels frame = new ProportionalPanels();
    frame.setVisible(true);
}
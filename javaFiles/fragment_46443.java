public class LabGuiDice extends JFrame {

    private JPanel contentPane;
    private JLabel diceIconLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    LabGuiDice frame = new LabGuiDice();
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
    public LabGuiDice() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JButton btnRollem = newDiceRoll();
        contentPane.add(btnRollem, BorderLayout.SOUTH);

        diceIconLabel = newDiceImage();
        contentPane.add(diceIconLabel, BorderLayout.CENTER);
        rollDice();
        pack();
    }

    private void rollDice() {
        Random random = new Random();
        int randomInt = random.nextInt(6) + 1;
        String resource = String.format("/Dice/die-%d.png", randomInt);
        Icon icon = new ImageIcon(LabGuiDice.class.getResource(resource));
        diceIconLabel.setIcon(icon);
    }

    private JLabel newDiceImage() {
        JLabel lblDice = new JLabel("");
        lblDice.setHorizontalAlignment(SwingConstants.CENTER);
        return lblDice;
    }

    private JButton newDiceRoll() {
        JButton btnRollem = new JButton("Roll 'Em");
        btnRollem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });
        btnRollem.setBorderPainted(false);
        btnRollem.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 27));
        btnRollem.setOpaque(true);
        btnRollem.setBackground(new Color(255, 0, 0));
        return btnRollem;
    }
}
public class TestConvertDistance {

    public static void main(String[] args) {
        new TestConvertDistance();
    }

    public TestConvertDistance() {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new DistancePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    protected class DistancePane extends JPanel {

        private JLabel lblInstruct;
        private JLabel lblMiles;
        private JLabel lblNauticalMiles;

        private JTextField fldMiles;
        private JTextField fldNauticalMiles;

        private JButton btnCalculate;

        public DistancePane() {

            lblInstruct = new JLabel("Enter the amount below to calculate");
            lblMiles = new JLabel("Miles");
            lblNauticalMiles = new JLabel("Nautical Miles");

            fldMiles = new JTextField(8);
            fldNauticalMiles = new JTextField(8);

            btnCalculate = new JButton("Convert");

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(2, 2, 2, 2);
            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(lblInstruct, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridwidth = 1;
            add(lblMiles, gbc);

            gbc.gridy++;
            add(lblNauticalMiles, gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            add(fldMiles, gbc);

            gbc.gridy++;
            add(fldNauticalMiles, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(btnCalculate, gbc);

            btnCalculate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Do your calculation here...
                }
            });

        }

    }

}
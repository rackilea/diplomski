public class ConverterPanel extends JPanel {
    private JLabel binaryLabel = new JLabel();
    private JLabel decimalLabel = new JLabel();
    private JTextField  hexString = new JTextField();
    // omitted some variables

    public ConverterPanel() {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 300));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JLabel converterName = new JLabel("Hexadecimal Converter");
        hexString.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertInput();
            }
        });

        JPanel panelName = new JPanel(new GridLayout(1,2));
        panelName.add(converterName);
        panelName.add(hexString);
        add(panelName, BorderLayout.NORTH);


        JPanel totalPanel = new JPanel(new GridLayout(1,3));
        totalPanel.add(new JLabel("Binary"));
        totalLabel = new JLabel("------");
        totalPanel.add(totalLabel);
        totalPanel.add(binaryLabel);

        JPanel totalPanel2 = new JPanel(new GridLayout(1,3));
        totalPanel2.add(new JLabel("Decimal"));
        totalLabel2 = new JLabel("------");
        totalPanel2.add(totalLabel2);
        totalPanel2.add(decimalLabel);

        JPanel south = new JPanel(new GridLayout(2,1));
        south.add(totalPanel);
        south.add(totalPanel2);
        add(south, BorderLayout.SOUTH);

    }        

    private void convertInput() {

        try {
            Integer n = Integer.valueOf(hexString.getText(), 16);
            decimalLabel.setText(String.valueOf(n));
            binaryLabel.setText(Integer.toBinaryString(n));
        } catch (NumberFormatException ee) {
            ee.printStackTrace();
        }
    }
}
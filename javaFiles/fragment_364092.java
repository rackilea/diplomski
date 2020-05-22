public class Panel extends JPanel {

    public Panel(){
        JPanel test = new JPanel(new GridBagLayout());
        String value = "10";
        final JTextField result = new JTextField();

        String[] quantities1 = {"0","1","2","3","4","5","6","7","8","9","10"};
        JComboBox quantitiesCB = new JComboBox(quantities1);
        quantitiesCB.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        String currentQuantity = (String)combo.getSelectedItem();
                        int value1 = Integer.valueOf(value);
                        int value2 = Integer.valueOf(currentQuantity);

                        String resultText = String.valueOf(value1*value2);
                        result.setText("$" + resultText);
                    }
                }            
        );

        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(640,480));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        add(quantitiesCB, gbc);
    } 
}
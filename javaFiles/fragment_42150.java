private double num;
private JTextField field = new JTextField();
private JButton button  = new JButton("Nutton");

...
button.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        num = Double.parseDouble(field.getText());
    }
});
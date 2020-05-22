jMenuItem1.addActionListener(new Handler() {
    @Override
    public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "The program calculates BMI based on information entered by user." , "The purpose of this program", JOptionPane.INFORMATION_MESSAGE);
    }
});

jMenuItem2.addActionListener(new Handler() {
    @Override
    public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "BMI Calc v. 1.0 " , "About", JOptionPane.INFORMATION_MESSAGE);
    }
});
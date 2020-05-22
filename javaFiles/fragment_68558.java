ActionListener actionListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton radioButton = (JRadioButton)e.getSource();
        String selectedOption = radioButton.getText();
        System.out.println(selectedOption );
    }
};

i1r1.addActionListener(actionListener);
i1r2.addActionListener(actionListener);
...
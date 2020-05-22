JButton button = new JButton("SomeButton");
button.addActionListener(this);

void ActionPerformed(ActionEvent e) {
    if(e.getSource() == button) {
        // do whatever you want if button is clicked
    }
}
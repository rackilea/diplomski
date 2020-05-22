private int buttonsPressed = 0;

public void actionPerformed(ActionEvent e) {
    buttonsPressed++;
    if(buttonsPressed >= 3) {
        JOptionPane.showMessageDialog(null, "You clicked three buttons", "App Title", JOptionPane.INFORMATION_MESSAGE);
        buttonsPressed = 0; //Assuming you want to reset the functionality
    }
}
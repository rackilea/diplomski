B.addActionListener(new ActionListener() { //Action Listener when pressing should change the color from Black to Red
    public void actionPerformed(ActionEvent e) {
        boolean right = false;
        if (change == Color.BLACK) {
            right = true;
            B.setForeground(Color.red);
        }
        if (right == true) {
            B.setForeground(Color.BLACK);
            right = false;
        }
    }
});
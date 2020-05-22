B.addActionListener(new ActionListener() { //Action Listener when pressing should change the color from Black to Red
    private boolean right = false;
    public void actionPerformed(ActionEvent e) {
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
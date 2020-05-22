B.addActionListener(new ActionListener() { //Action Listener when pressing should change the color from Black to Red
    private boolean right = false;
    public void actionPerformed(ActionEvent e) {
        if (!right) {
            B.setForeground(Color.red);
        } else if (right) {
            B.setForeground(Color.BLACK);
        }
        right = !right;
    }

});
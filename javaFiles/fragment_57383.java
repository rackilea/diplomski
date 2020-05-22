for (int i=1; i<=7; i++) {
    for (int j=1; j<=7; j++) {
        JButton btn = new JButton("Button " + i + ", " + j);
        // store the button in an array if you want
        btn.addActionListener(new PoseActionListener(btn, i, j);
    }
}
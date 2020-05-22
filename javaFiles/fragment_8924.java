javax.swing.Timer timer = new javax.swing.Timer(500, new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        counter++;
        label.setText(count);
    }
});
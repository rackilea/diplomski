button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        new SecondFrame().setVisible(true);
        FirstFrame.this.dispose(); // if you want the first frame to close
    }
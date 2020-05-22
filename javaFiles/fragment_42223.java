// change color and repaint
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnChoice) {
            JColorChooser jcc = new JColorChooser();
            c = jcc.showDialog(btnChoice, "Choose Circle Color", Color.BLUE);
        } else {
            c = this.color;
        }
        repaint();
    }
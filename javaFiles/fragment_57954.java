@Override
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == this.button1) {
        System.out
            .println(((MatrixButton) ae.getSource()).getRow() + "," + ((MatrixButton) ae.getSource()).getCol());
    } else if (ae.getSource() == this.button2) {
        // TODO
    } else if (ae.getSource() == this.button3) {
        // TODO
    }
    }
public void actionPerformed(ActionEvent ae) {
    Object source = ae.getSource();
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (source == (buttons[i][j])) {
                //...
                break;
            }
        }
    }
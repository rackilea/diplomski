for (int i = 0; i < 8; i++) {
    for (int j = 0; j < 8; j++) {
        final int iValue = i;
        squares[i][j].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!pressed) {
                    pressed = true;
                    fromR = iValue;
                }
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }
}
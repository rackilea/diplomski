private void addActionListenerTo(WhateverThisIs square, int i) {
    square.addActionListener(e -> {
        if (!pressed) {
            pressed = true;
            fromR = i;
        }
        throw new UnsupportedOperationException("Not supported yet.");
    });
}
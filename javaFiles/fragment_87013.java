for (int i=0; i<8; i++) {
        gridLabel[i] = new JLabel("Hello");
    }

    for (int i=0; i<8; i++) {
        gridLabel[i].setIcon(gridPic);
        add(gridLabel[i]);
    }
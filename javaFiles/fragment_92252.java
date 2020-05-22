private GridBagConstraints newComponent(int x, int y, int w, int h) {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = y != 2 && y != 3 ? GridBagConstraints.HORIZONTAL : GridBagConstraints.BOTH;
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = w;
        c.gridheight = h;
        if (y == 2 || y == 3) {
            c.weighty = 1.0;
        }
        if (x <=4 && (x + w) >=4) {
            c.weightx = 1.0;
        }
        return c;
    }
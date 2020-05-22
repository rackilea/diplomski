private JTextField selected;

selected = x;
    x.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            selected = x;
        }
    });
    y.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            selected = y;
        }
    });
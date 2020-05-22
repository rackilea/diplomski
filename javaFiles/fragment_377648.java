class Bild extends JFrame {

    public JButton createButton() {
        JButton b = new JButton();
        Border border = new LineBorder(Color.BLACK, 1);
        b.setBorder(border);
        b.setBackground(Color.WHITE);
        return b;
    }

    public Bild() {
        setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 100; i++) {
            add(createButton());
        }
    }
}
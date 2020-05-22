class Bild extends JFrame {

    public JButton createButton() {
        JButton b = new JButton() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(10, 10);
            }
        };
        Border border = new LineBorder(Color.BLACK, 1);
        b.setBorder(border);
        b.setBackground(Color.WHITE);
        return b;
    }

    public Bild() {
        JPanel panel = new JPanel(new GridLayout(10, 10));
        for (int i = 0; i < 100; i++) {
            panel.add(createButton());
        }
        setLayout(new GridBagLayout());
        add(panel);
    }
}
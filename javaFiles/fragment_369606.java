JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
JPanel p2 = new JPanel(new GridLayout(13, 1));
for (int i = 0; i < 13; i++) {
    p2.add(new JButton("Button " + i));
}
p1.add(p2);
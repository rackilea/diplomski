JPanel comp = new JPanel();
comp.setLayout(new GridLayout(1, 20));
for (int i = 0; i < 20; i++) {
    comp.add(new JLabel(String.format("  %d", i)));
}

JScrollPane scroll = new JScrollPane(comp, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
BiConsumer<Integer, Integer> setview = (x, y) -> {
    Point p = scroll.getViewport().getViewPosition();
    scroll.getViewport().setViewPosition(new Point(p.x + x, p.y + y));
};
JButton left = new JButton("<");
left.addActionListener(e -> setview.accept(-10, 0));
JButton right = new JButton(">");
right.addActionListener(e -> setview.accept(+10, 0));

JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(new BorderLayout());
frame.add(scroll, BorderLayout.CENTER);
frame.add(right, BorderLayout.EAST);
frame.add(left, BorderLayout.WEST);
frame.pack();
frame.setVisible(true);
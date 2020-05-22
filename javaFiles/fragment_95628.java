public static void main(String[] args) {

    JScrollPane scroll = new JScrollPane(new JTree());
    scroll.setViewportBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JFrame frame = new JFrame("Test");
    frame.add(scroll);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
}
public static void main(String[] args) {

    JTree tree = new JTree();
    tree.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    JFrame frame = new JFrame("Test");
    frame.add(new JScrollPane(tree));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
}
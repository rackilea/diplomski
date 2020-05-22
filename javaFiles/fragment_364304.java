final JTextField field = new JTextField();
final JTree tree = new JTree(new String[] {"Hello World", "StackOverflow"});
tree.setCellRenderer(new DefaultTreeCellRenderer() {
    @Override
    public Component getTreeCellRendererComponent(JTree tree,
            Object value, boolean sel, boolean expanded, boolean leaf,
            int row, boolean hasFocus) {

        String search = field.getText();
        String text = value.toString();

        StringBuffer html = new StringBuffer("<html>");
        Matcher m = Pattern.compile(Pattern.quote(search)).matcher(text);
        while (m.find())
            m.appendReplacement(html, "<b>" + m.group() + "</b>");
        m.appendTail(html).append("</html>");

        return super.getTreeCellRendererComponent(
                tree, html.toString(), sel, expanded, leaf, row, hasFocus);
    }
});
field.addKeyListener(new KeyAdapter() {
    @Override public void keyReleased(KeyEvent e) { update(); }
    private void update() { 
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        model.nodeStructureChanged((TreeNode) model.getRoot());
    }
});
JFrame frame = new JFrame("Test");
frame.add(field, BorderLayout.NORTH);
frame.add(tree, BorderLayout.CENTER);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(400, 300);
frame.setVisible(true);
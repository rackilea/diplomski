public Component getTreeCellRendererComponent(final JTree tree, final Object value,
            final boolean sel, final boolean expanded, final boolean leaf, final int row,
            final boolean hasFocus) {
        // Trying to change color of tree

        JLabel label = (JLabel) super.getTreeCellRendererComponent(tree, value,
                sel, expanded, leaf, row, hasFocus);
        setForeground(Color.RED);
        return label;// Or "return this", since the method actually returns the renderer component itself
    }
});
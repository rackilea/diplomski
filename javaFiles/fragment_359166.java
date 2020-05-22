public class TreeCellEditorDelegate extends DefaultTreeCellEditor {

    private final TreeCellEditor    editorParent;
    private final TreeCellEditor    editorLeaf;

    public TreeCellEditorDelegate(
            final JTree tree,
            final DefaultTreeCellRenderer renderer,
            final TreeCellEditor editorParent,
            final TreeCellEditor editorLeaf) {
        super(tree, renderer);
        this.editorParent = editorParent;
        this.editorLeaf = editorLeaf;
    }

    @Override
    public Component getTreeCellEditorComponent(
            final JTree tree,
            final Object value,
            final boolean isSelected,
            final boolean expanded,
            final boolean leaf,
            final int row) {
        if (leaf)
            return editorLeaf.getTreeCellEditorComponent(tree, value, isSelected, expanded, true, row);
        else
            return editorParent.getTreeCellEditorComponent(tree, value, isSelected, expanded, false, row);
    }
}
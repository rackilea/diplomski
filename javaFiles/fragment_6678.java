public class TreeNodeEditor  extends AbstractCellEditor implements TreeCellEditor {

    private JTree tree;
    private TreeNodeModel editedModel = null;

    TreeNodeRenderer renderer = new TreeNodeRenderer();

    public TreeNodeEditor(JTree tree) {
        this.tree=tree;
    }

    @Override
    public boolean isCellEditable(EventObject event) {

        boolean editable=false;

        if (event instanceof MouseEvent) {

            MouseEvent mouseEvent = (MouseEvent) event;
            TreePath path = tree.getPathForLocation(mouseEvent.getX(),mouseEvent.getY());

            if (path != null) {

                Object node = path.getLastPathComponent();

                if ((node != null) && (node instanceof DefaultMutableTreeNode)) {

                    DefaultMutableTreeNode editedNode = (DefaultMutableTreeNode) node;
                    TreeNodeModel model = (TreeNodeModel) editedNode.getUserObject();
                    editable = model.hasCheckBox;

                }   //if (node)
            }   //if (path)
        }   //if (MouseEvent)

        return editable;

    }

    public Object getCellEditorValue() {

        JCheckBox checkbox = renderer.getCheckBoxRenderer();

        TreeNodeModel model = new TreeNodeModel(editedModel.getKey(), checkbox.getText(), true, checkbox.isSelected());
        return model;

    }

    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {

        if (((DefaultMutableTreeNode) value).getUserObject() instanceof TreeNodeModel) {
            editedModel = (TreeNodeModel) ((DefaultMutableTreeNode) value).getUserObject();
        }

        Component editor = renderer.getTreeCellRendererComponent(tree, value, true, expanded, leaf, row, true);

        // editor always selected / focused
        ItemListener itemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                if (stopCellEditing())
                    fireEditingStopped();
            }
        };

        if (editor instanceof JCheckBox) {
            ((JCheckBox) editor).addItemListener(itemListener);
        }

        return editor;
    }

}
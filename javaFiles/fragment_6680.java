private Map<Integer, String> checked = new HashMap<Integer, String>();

private void Button_CheckedActionPerformed(java.awt.event.ActionEvent evt) {

    DefaultTableModel tableModel = ((DefaultTableModel) Table_Nodes.getModel());
    tableModel.getDataVector().removeAllElements();
    tableModel.fireTableDataChanged();

    checked.clear();

    DefaultTreeModel treeModel = (DefaultTreeModel) Tree_Nodes.getModel();
    DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();

    getChildNodes(root);

    for (Iterator it=checked.entrySet().iterator(); it.hasNext(); ) {
        Map.Entry entry = (Map.Entry)it.next();
        tableModel.addRow(new Object[] {entry.getKey(), entry.getValue()});
    }

    Button_Checked.requestFocus();


}

private void getChildNodes(DefaultMutableTreeNode parentNode) {

    for (Enumeration e=parentNode.children(); e.hasMoreElements();) {

        DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) e.nextElement();
        TreeNodeModel model = (TreeNodeModel) childNode.getUserObject();

        if (model.hasCheckBox && model.isSelected()) {
            checked.put(model.getKey(), model.getValue());
        }

        //recurse
        if (childNode.getChildCount()>0) getChildNodes(childNode);

    }

}
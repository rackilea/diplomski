protected TreeSelectionListener createFakeDataEventSelectionListener() {
    TreeSelectionListener l = new TreeSelectionListener() {

        @Override
        public void valueChanged(final TreeSelectionEvent e) {
            fireDataChanged(e.getOldLeadSelectionPath());
            fireDataChanged(e.getNewLeadSelectionPath());
        }

        private void fireDataChanged(TreePath lead) {
            if (lead == null) return;
            DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
            TreeNode last = (TreeNode) lead.getLastPathComponent();
            model.nodeChanged(last);
        }
    };
    return l;
}
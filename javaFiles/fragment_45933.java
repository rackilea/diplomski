tree.addTreeSelectionListener(new TreeSelectionListener() {
    public void valueChanged(TreeSelectionEvent e) {
        TreePath tp = tree.getSelectionPath();
        if (tp != null) {
            Object filePathToAdd = tp.getLastPathComponent();
            System.out.println(filePathToAdd);
            if (filePathToAdd instanceof FileTreeNode) {
                FileTreeNode node = (FileTreeNode) filePathToAdd;
                File file = node.getFile();
                System.out.println(file);
            }
        }
    }
});
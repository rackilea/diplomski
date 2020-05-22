JTree tree = new JTree();
DefaultMutableTreeNode root = new DefaultMutableTreeNode("Animals");
DefaultTreeModel model = new DefaultTreeModel(root);

tree.setModel(model);
root.add(new DefaultMutableTreeNode(new Animal("Dog","ACS")));
root.add(new DefaultMutableTreeNode(new Animal("Cat","BCS")));
root.add(new DefaultMutableTreeNode(new Animal("Lion","FCS")));

DefaultTreeSelectionModel sModel = new DefaultTreeSelectionModel(); 

sModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
tree.setSelectionModel(sModel);
tree.addTreeSelectionListener(new TreeSelectionListener() {

    @Override
    public void valueChanged(TreeSelectionEvent selection) {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)selection.getPath().getLastPathComponent();
        if(selectedNode.isLeaf()) {
            Animal animal = (Animal)selectedNode.getUserObject();
        }
    }
});
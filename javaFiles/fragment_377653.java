@Override
public void valueChanged(TreeSelectionEvent e) {

    TreePath[] selectedPaths = tree.getSelectionPaths();
    TreePath parentPath = tree.getClosestPathForLocation(1, 1);

    if (selectedPaths == null)
        return;

    ArrayList<Integer> validRows = new ArrayList<>();

    for (TreePath tp : selectedPaths){

        if (tp.getParentPath() != parentPath)
            continue;

        //get node that current selected path points too, then get the custom index of that
        CustomTreeNode selectedNode = (CustomTreeNode) tp.getLastPathComponent();

        System.out.println(selectedNode.getPosition());

        validRows.add(selectedNode.getPosition());

}
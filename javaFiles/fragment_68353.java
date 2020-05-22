@Override
public String getToolTipText(MouseEvent evt) {
    if (getRowForLocation(evt.getX(), evt.getY()) == -1)
      return null;
    TreePath curPath = getPathForLocation(evt.getX(), evt.getY());
    TreeNode node = (TreeNode)curPath.getLastPathComponent();
    if(something)
        return "Empty";

    if(something_else)
        return "Not empty";

    return null;
  }
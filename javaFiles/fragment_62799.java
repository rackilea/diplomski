// Get drop location info.
int childIndex;
TreePath dest;
if (support.isDrop()) {
  JTree.DropLocation dl = (JTree.DropLocation) support.getDropLocation();
  childIndex = dl.getChildIndex();
  dest = dl.getPath();
} else {
  childIndex = -1;
  JTree tree = (JTree) support.getComponent();
  dest = tree.getSelectionPath();
}
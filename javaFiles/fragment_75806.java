public class ClassCellRenderer implements javax.swing.tree.TreeCellRenderer {

JLabel className = new JLabel(" ");
JButton renderer = new JButton();
DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();

public ClassCellRenderer() {
    renderer.add(className);
}

@Override
public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
    Component returnValue = null;
    if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
      Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
      if (userObject instanceof String) {
          String e = (String) userObject;
          className.setText(e);
      }
      returnValue = renderer;
    }
    if (returnValue == null) {
      returnValue = defaultRenderer.getTreeCellRendererComponent(tree, value, selected, expanded,
          leaf, row, hasFocus);
    }
    return returnValue;
}
}
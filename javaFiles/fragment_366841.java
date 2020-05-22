import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.tree.*;

public class JComboBoxJTree2 {
  public JComponent makeUI() {
    String[] m = {"Running", "Paused", "Stopped"};
    DefaultMutableTreeNode root = new DefaultMutableTreeNode(new Node("Plugins"));
    root.add(new DefaultMutableTreeNode(new Node("Plugin 1", m)));
    root.add(new DefaultMutableTreeNode(new Node("Plugin 2", m)));
    DefaultMutableTreeNode leaf = new DefaultMutableTreeNode(new Node("Plugin 3", m));
    root.add(leaf);
    leaf.add(new DefaultMutableTreeNode(new Node("Plugin 3A", m)));
    leaf.add(new DefaultMutableTreeNode(new Node("Plugin 3B", m)));

    JTree tree = new JTree(root);
    RendererDispatcher rendererDispatcher = new RendererDispatcher(new JComboBox<String>());
    RendererDispatcher editorDispatcher = new RendererDispatcher(new JComboBox<String>());
    tree.setCellRenderer(rendererDispatcher);
    tree.setCellEditor(editorDispatcher);
    tree.setEditable(true);

    return new JScrollPane(tree);
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new JComboBoxJTree2().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}

class Node {
  private final String name;
  private final String[] plugins;
  private int selectedPluginIndex;
  public Node(String name, String... plugins) {
    this.name = name;
    this.plugins = plugins;
  }
  public String toString() {
    return name;
  }
  public int getSelectedPluginIndex() {
    return selectedPluginIndex;
  }
  public void setSelectedPluginIndex(int selectedPluginIndex) {
    this.selectedPluginIndex = selectedPluginIndex;
  }
  public String[] getPlugins() {
    return plugins;
  }
}

class RendererDispatcher extends DefaultCellEditor implements TreeCellRenderer {
  private final JPanel panel = new JPanel();
  private final JLabel pluginName = new JLabel();
  private final JComboBox<String> comboBox;
  private Node node;

  public RendererDispatcher(JComboBox<String> comboBox) {
    super(comboBox);
    this.comboBox = comboBox;
    panel.setOpaque(false);
    panel.add(pluginName);
    panel.add(comboBox);
  }
  @Override public Component getTreeCellRendererComponent(
      JTree tree, Object value, boolean selected, boolean expanded,
      boolean leaf, int row, boolean hasFocus) {
    Node node = extractNode(value);
    setContents(node);
    return panel;
  }
  @Override public Component getTreeCellEditorComponent(
      JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row) {
    Node node = extractNode(value);
    setContents(node);
    this.node = node;
    return panel;
  }
  @Override public Object getCellEditorValue() {
    Object o = super.getCellEditorValue();
    DefaultComboBoxModel<String> m = (DefaultComboBoxModel<String>) comboBox.getModel();
    Node n = new Node(pluginName.getText(), node.getPlugins());
    n.setSelectedPluginIndex(m.getIndexOf(o));
    return n;
  }
  @Override public boolean isCellEditable(final EventObject event) {
    Object source = event.getSource();
    if (!(source instanceof JTree) || !(event instanceof MouseEvent)) {
      return false;
    }
    final JTree tree = (JTree) source;
    final MouseEvent mouseEvent = (MouseEvent) event;
    final TreePath path = tree.getPathForLocation(mouseEvent.getX(), mouseEvent.getY());
    if (path == null) {
      return false;
    }
    Object node = path.getLastPathComponent();
    if (node == null || !(node instanceof DefaultMutableTreeNode)) {
      return false;
    }

    Rectangle r = tree.getPathBounds(path);
    if (r == null) {
      return false;
    }
    Dimension d = panel.getPreferredSize();
    r.setSize(new Dimension(d.width, r.height));
    if (r.contains(mouseEvent.getX(), mouseEvent.getY())) {
      EventQueue.invokeLater(new Runnable() {
        @Override public void run() {
          Point pt = SwingUtilities.convertPoint(tree, mouseEvent.getPoint(), panel);
          //System.out.println(pt);
          Object o = SwingUtilities.getDeepestComponentAt(panel, pt.x, pt.y);
          if (o instanceof JComboBox) {
            comboBox.showPopup();
          } else if (o instanceof Component) {
            Object oo = SwingUtilities.getAncestorOfClass(JComboBox.class, (Component) o);
            if (oo instanceof JComboBox) {
              comboBox.showPopup();
            }
          }
        }
      });
      return true;
    }
    return delegate.isCellEditable(event);
  }
  private static Node extractNode(Object value) {
    if (value instanceof DefaultMutableTreeNode) {
      DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
      Object userObject = node.getUserObject();
      if (userObject instanceof Node) {
        return (Node) userObject;
      }
    }
    return null;
  }
  private void setContents(Node node) {
    if (node == null) {
      return;
    }
    pluginName.setText(node.toString());
    DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) comboBox.getModel();
    model.removeAllElements();
    if (node.getPlugins().length > 0) {
      panel.add(comboBox);
      for (String s : node.getPlugins()) {
        model.addElement(s);
      }
      comboBox.setSelectedIndex(node.getSelectedPluginIndex());
    } else {
      panel.remove(comboBox);
    }
  }
}
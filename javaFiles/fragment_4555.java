import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetContext;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.EventObject;
import java.util.HashMap;

import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import com.wanasis.vlc.control.GridManager;
import com.wanasis.vlc.domain.SourceNode;

public class JCheckBoxDragableTree extends JTree {

    /**
     * 
     */
    private static final long serialVersionUID = -776897819237333316L;
    private HashMap<String, SourceNode> configurableSources;
    private static HashMap<String, String> displaySources = new HashMap<>();

    private static DefaultMutableTreeNode root = new DefaultMutableTreeNode("wanaDVR");

    TreeDragSource ds;

    TreeDropTarget dt;

    public JCheckBoxDragableTree(HashMap<String, SourceNode> configurableSources, HashMap<String, String> displaySources) {
        super(root);
        System.out.println("JCheckBoxDragableTree");
        setupTreeElements(configurableSources);

        this.configurableSources = configurableSources;
        this.displaySources = displaySources;

        setCellRenderer(new CheckBoxTreeNodeRenderer());
        setCellEditor(new CheckBoxTreeNodeEditor(this));
        setEditable(true);
        ds = new TreeDragSource(this, DnDConstants.ACTION_COPY_OR_MOVE);
        dt = new TreeDropTarget(this);

        addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {

                GridManager gm = GridManager.getInstance();
                String key = "" + e.getPath().getLastPathComponent();
                DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
                System.out.println(dmtn.getUserObject());
                System.out.println(key);


            }
        });
    }

    public void setupTreeElements(HashMap<String, SourceNode> configurableSources) {
        final HashMap<String, DefaultMutableTreeNode> parents = new HashMap<>();
        final HashMap<String, SourceNode> reste = new HashMap<>();

        configurableSources.values().stream().filter(s -> {
            return s.getParent().isEmpty()||s.getParent().trim().toLowerCase().equals("wanadvr");
        }).forEachOrdered(child -> {
            String key = child.getId();
            DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(key);
            parents.put(key, newChild);
            root.add(newChild);
        });
        configurableSources.values().stream().filter(s -> {
            return !s.getParent().isEmpty() && !s.getParent().trim().toLowerCase().equals("wanadvr");
        }).forEachOrdered(child -> {
            String parentKey = child.getParent();
            String key = child.getId();
            DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(key);
            if (parents.keySet().contains(parentKey)) {
                parents.get(parentKey).add(newChild);
                parents.put(key, newChild);
            } else {
                reste.put(key, child);
            }
        });
        while (reste.size() > 0) {
            reste.values().stream().forEachOrdered(child -> {
                String parentKey = child.getParent();
                String key = child.getId();
                DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(key);
                if (parents.keySet().contains(parentKey)) {
                    parents.get(parentKey).add(newChild);
                    parents.put(key, newChild);
                    reste.remove(key);
                }
            });
        }
    }
}

class TreeNodeCheckBox extends JCheckBox {

    public TreeNodeCheckBox() {
        this("", false);
    }

    public TreeNodeCheckBox(final String text, final boolean selected) {
        this(text, null, selected);
    }

    public TreeNodeCheckBox(final String text, final Icon icon, final boolean selected) {
        super(text, icon, selected);
        setMargin(new Insets(1, 1, 1, 1));

        System.out.println(text);
        System.out.println(isSelected());
        GridManager instance = GridManager.getInstance();
        if (isSelected()) {
            instance.getDisplayableSources().put(text, instance.getConfigurableSources().get(text).getSource());

        }else {
            instance.getDisplayableSources().remove(text);
        }
        instance.prepareDisplay();
    }
}

class CheckBoxTreeNodeRenderer implements TreeCellRenderer {
    Color selectionBorderColor, selectionForeground, selectionBackground, textForeground, textBackground;
    private TreeNodeCheckBox treeNodeCheckBox = new TreeNodeCheckBox();
    private DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();

    public CheckBoxTreeNodeRenderer() {
        Font fontValue;
        fontValue = UIManager.getFont("Tree.font");
        if (fontValue != null) {
            treeNodeCheckBox.setFont(fontValue);
        }
        Boolean booleanValue = (Boolean) UIManager.get("Tree.drawsFocusBorderAroundIcon");
        treeNodeCheckBox.setFocusPainted((booleanValue != null) && (booleanValue.booleanValue()));

        selectionBorderColor = UIManager.getColor("Tree.selectionBorderColor");
        selectionForeground = UIManager.getColor("Tree.selectionForeground");
        selectionBackground = UIManager.getColor("Tree.selectionBackground");
        textForeground = UIManager.getColor("Tree.textForeground");
        textBackground = UIManager.getColor("Tree.textBackground");
    }

    protected TreeNodeCheckBox getCheckBoxRenderer() {
        return treeNodeCheckBox;
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
            boolean leaf, int row, boolean hasFocus) {
        Component component;
        if (leaf) {         
            String stringValue = tree.convertValueToText(value, selected, expanded, leaf, row, false);

            treeNodeCheckBox.setText(stringValue);
            treeNodeCheckBox.setSelected(GridManager.getInstance().getDisplayableSources().keySet().contains(stringValue));
            treeNodeCheckBox.setEnabled(tree.isEnabled());
            if (selected) {
                treeNodeCheckBox.setBorder(new LineBorder(selectionBorderColor));
                treeNodeCheckBox.setForeground(selectionForeground);
                treeNodeCheckBox.setBackground(selectionBackground);
            } else {
                treeNodeCheckBox.setBorder(null);
                treeNodeCheckBox.setForeground(textForeground);
                treeNodeCheckBox.setBackground(textBackground);
            }
            if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
                Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
                if (userObject instanceof TreeNodeCheckBox) {
                    TreeNodeCheckBox node = (TreeNodeCheckBox) userObject;
                    treeNodeCheckBox.setText(node.getText());
                    treeNodeCheckBox.setSelected(node.isSelected());
                }
            }
            component = treeNodeCheckBox;
        } else {
            component = defaultRenderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row,
                    hasFocus);
        }
        return component;
    }
}

class CheckBoxTreeNodeEditor extends AbstractCellEditor implements TreeCellEditor {
    CheckBoxTreeNodeRenderer renderer = new CheckBoxTreeNodeRenderer();
    JTree tree;

    public CheckBoxTreeNodeEditor(JTree tree) {
        this.tree = tree;
    }

    public Object getCellEditorValue() {
        TreeNodeCheckBox checkBox = renderer.getCheckBoxRenderer();
        TreeNodeCheckBox checkBoxNode = new TreeNodeCheckBox(checkBox.getText(), checkBox.isSelected());
        return checkBoxNode;
    }

    public boolean isCellEditable(EventObject event) {
        boolean editable = false;
        if (event instanceof MouseEvent) {
            MouseEvent mouseEvent = (MouseEvent) event;
            TreePath path = tree.getPathForLocation(mouseEvent.getX(), mouseEvent.getY());
            if (path != null) {
                Object node = path.getLastPathComponent();
                if ((node != null) && (node instanceof DefaultMutableTreeNode)) {
                    DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) node;
                    editable = treeNode.isLeaf();
                }
            }
        }
        return editable;
    }

    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean selected, boolean expanded,
            boolean leaf, int row) {
        Component editor = renderer.getTreeCellRendererComponent(tree, value, true, expanded, leaf, row, true);
        if (editor instanceof TreeNodeCheckBox) {
            ((TreeNodeCheckBox) editor).addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent itemEvent) {
                    if (stopCellEditing()) {
                        fireEditingStopped();
                    }
                }
            });
        }
        return editor;
    }

}

class TreeDragSource implements DragSourceListener, DragGestureListener {

    DragSource source;

    DragGestureRecognizer recognizer;

    TransferableTreeNode transferable;

    DefaultMutableTreeNode oldNode;

    JTree sourceTree;

    public TreeDragSource(JTree tree, int actions) {
        sourceTree = tree;
        source = new DragSource();
        recognizer = source.createDefaultDragGestureRecognizer(sourceTree, actions, this);
    }

    /*
     * Drag Gesture Handler
     */
    public void dragGestureRecognized(DragGestureEvent dge) {
        TreePath path = sourceTree.getSelectionPath();
        if ((path == null) || (path.getPathCount() <= 1)) {
            // We can't move the root node or an empty selection
            return;
        }
        oldNode = (DefaultMutableTreeNode) path.getLastPathComponent();
        transferable = new TransferableTreeNode(path);
        // source.startDrag(dge, DragSource.DefaultMoveNoDrop, transferable, this);

        // If you support dropping the node anywhere, you should probably
        // start with a valid move cursor:
        source.startDrag(dge, DragSource.DefaultMoveDrop, transferable, this);
    }

    /*
     * Drag Event Handlers
     */
    public void dragEnter(DragSourceDragEvent dsde) {
    }

    public void dragExit(DragSourceEvent dse) {
    }

    public void dragOver(DragSourceDragEvent dsde) {
    }

    public void dropActionChanged(DragSourceDragEvent dsde) {
        System.out.println("Action: " + dsde.getDropAction());
        System.out.println("Target Action: " + dsde.getTargetActions());
        System.out.println("User Action: " + dsde.getUserAction());
    }

    public void dragDropEnd(DragSourceDropEvent dsde) {
        /*
         * to support move or copy, we have to check which occurred:
         */
        System.out.println("Drop Action: " + dsde.getDropAction());
        if (dsde.getDropSuccess() && (dsde.getDropAction() == DnDConstants.ACTION_MOVE)) {
            ((DefaultTreeModel) sourceTree.getModel()).removeNodeFromParent(oldNode);
        }

        /*
         * to support move only... if (dsde.getDropSuccess()) {
         * ((DefaultTreeModel)sourceTree.getModel()).removeNodeFromParent(oldNode); }
         */
    }
}

// TreeDropTarget.java
// A quick DropTarget that's looking for drops from draggable JTrees.
//

class TreeDropTarget implements DropTargetListener {

    DropTarget target;

    JTree targetTree;

    public TreeDropTarget(JTree tree) {
        targetTree = tree;
        target = new DropTarget(targetTree, this);
    }

    /*
     * Drop Event Handlers
     */
    private TreeNode getNodeForEvent(DropTargetDragEvent dtde) {
        Point p = dtde.getLocation();
        DropTargetContext dtc = dtde.getDropTargetContext();
        JTree tree = (JTree) dtc.getComponent();
        TreePath path = tree.getClosestPathForLocation(p.x, p.y);
        return (TreeNode) path.getLastPathComponent();
    }

    public void dragEnter(DropTargetDragEvent dtde) {
        TreeNode node = getNodeForEvent(dtde);
        if (node.isLeaf()) {
            dtde.rejectDrag();
        } else {
            // start by supporting move operations
            // dtde.acceptDrag(DnDConstants.ACTION_MOVE);
            dtde.acceptDrag(dtde.getDropAction());
        }
    }

    public void dragOver(DropTargetDragEvent dtde) {
        TreeNode node = getNodeForEvent(dtde);
        if (node.isLeaf()) {
            dtde.rejectDrag();
        } else {
            // start by supporting move operations
            // dtde.acceptDrag(DnDConstants.ACTION_MOVE);
            dtde.acceptDrag(dtde.getDropAction());
        }
    }

    public void dragExit(DropTargetEvent dte) {
    }

    public void dropActionChanged(DropTargetDragEvent dtde) {
    }

    public void drop(DropTargetDropEvent dtde) {
        Point pt = dtde.getLocation();
        DropTargetContext dtc = dtde.getDropTargetContext();
        JTree tree = (JTree) dtc.getComponent();
        TreePath parentpath = tree.getClosestPathForLocation(pt.x, pt.y);
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) parentpath.getLastPathComponent();


        if (parent.isLeaf()) {
            dtde.rejectDrop();
            return;
        }

        try {
            Transferable tr = dtde.getTransferable();
            DataFlavor[] flavors = tr.getTransferDataFlavors();
            for (int i = 0; i < flavors.length; i++) {
                if (tr.isDataFlavorSupported(flavors[i])) {
                    dtde.acceptDrop(dtde.getDropAction());
                    TreePath p = (TreePath) tr.getTransferData(flavors[i]);
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) p.getLastPathComponent();
                    DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                    model.insertNodeInto(node, parent, 0);
                    dtde.dropComplete(true);
                    System.out.println("dragged node : "+node);
                    System.out.println("dropped in parent : "+parent);
                    GridManager.getInstance().getConfigurableSources().get(""+node).setParent(""+parent);
                    System.out.println(GridManager.getInstance().getConfigurableSources().values());

                    return;
                }
            }
            dtde.rejectDrop();
        } catch (Exception e) {
            e.printStackTrace();
            dtde.rejectDrop();
        }
    }
}

// TransferableTreeNode.java
// A Transferable TreePath to be used with Drag & Drop applications.
//

class TransferableTreeNode implements Transferable {

    public static DataFlavor TREE_PATH_FLAVOR = new DataFlavor(TreePath.class, "Tree Path");

    DataFlavor flavors[] = { TREE_PATH_FLAVOR };

    TreePath path;

    public TransferableTreeNode(TreePath tp) {
        path = tp;
    }

    public synchronized DataFlavor[] getTransferDataFlavors() {
        return flavors;
    }

    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return (flavor.getRepresentationClass() == TreePath.class);
    }

    public synchronized Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (isDataFlavorSupported(flavor)) {
            return (Object) path;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}
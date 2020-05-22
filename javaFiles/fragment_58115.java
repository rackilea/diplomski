public class TaskPaneView extends JScrollPane {

    private transient ExplorerManager manager;
    // create a taskpanecontainer
    JXTaskPaneContainer taskpanecontainer = new JXTaskPaneContainer();
    /** Listener to nearly everything */
    transient Listener managerListener;
    /** weak variation of the listener for property change on the explorer manager */
    transient PropertyChangeListener wlpc;

    /** True, if the selection listener is attached. */
    transient boolean listenerActive;

    // UI Settings:
    Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
    Painter backgroundPainter = new MattePainter(Color.white);

    public TaskPaneView() {
        setViewportView(taskpanecontainer);
    }

    public void setBackground(Painter background) {
        this.backgroundPainter = background;
    }

    public void setLabelFont(Font labelFont) {
        this.labelFont = labelFont;
    }

    @Override
    public void addNotify() {
        super.addNotify();
        ExplorerManager em = ExplorerManager.find(this);
        if (em != manager) {
            if (manager != null) {
                manager.removePropertyChangeListener(wlpc);
            }
            manager = em;
            manager.addPropertyChangeListener(wlpc = WeakListeners.propertyChange(managerListener, manager));
            Node root = manager.getExploredContext();
            setRootNode(root);
        } else {
            // bugfix #23509, the listener were removed --> add it again
            if (!listenerActive && (manager != null)) {
                manager.addPropertyChangeListener(wlpc = WeakListeners.propertyChange(managerListener, manager));
            }
        }
    }

    /** Removes listeners.
     */
    @Override
    public void removeNotify() {
        super.removeNotify();
        listenerActive = false;
        // bugfix #23509, remove useless listeners
        if (manager != null) {
            manager.removePropertyChangeListener(wlpc);
        }
    }

    private void setRootNode(Node root) {
        //throw new UnsupportedOperationException("Not yet implemented");
        taskpanecontainer.removeAll();

        System.out.println("root node set " + root);
        Node[] children = root.getChildren().getNodes();
        for (int i = 0; i < children.length; i++) {
            Node node = children[i];
            JXTaskPane taskPane = new JXTaskPane();
            taskPane.setName(node.getName());
            taskPane.setCollapsed(true);
            taskPane.setTitle(node.getDisplayName());
            taskPane.setIcon(new ImageIcon(node.getIcon(BeanInfo.ICON_COLOR_16x16)));
            Action [] actions = node.getActions(true);
            for (int j = 0; j < actions.length; j++) {
                Action action = actions[j];
                taskPane.add(action);
            }
            taskpanecontainer.add(taskPane);
        }
    }

    private final class Listener implements PropertyChangeListener {

        public void propertyChange(PropertyChangeEvent evt) {

            if (ExplorerManager.PROP_EXPLORED_CONTEXT.equals(evt.getPropertyName())) {
                setRootNode(manager.getExploredContext());
                return;
            }
        }
    }
}
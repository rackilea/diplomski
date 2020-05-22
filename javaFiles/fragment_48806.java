class ExitAction extends AbstractAction {
    public ExitAction() {
        super("Exit");
    }
    @Override public void actionPerformed(ActionEvent e) {
        JComponent c = (JComponent) e.getSource();
        Window window = null;
        Container parent = c.getParent();
        if (parent instanceof JPopupMenu) {
            JPopupMenu popup = (JPopupMenu) parent;
            JComponent invoker = (JComponent) popup.getInvoker();
            window = SwingUtilities.getWindowAncestor(invoker);
        } else if (parent instanceof JToolBar) {
            JToolBar toolbar = (JToolBar) parent;
            if (((BasicToolBarUI) toolbar.getUI()).isFloating()) {
                window = SwingUtilities.getWindowAncestor(toolbar).getOwner();
            } else {
                window = SwingUtilities.getWindowAncestor(toolbar);
            }
        } else {
            Component invoker = c.getParent();
            window = SwingUtilities.getWindowAncestor(invoker);
        }
        if (window != null) {
            //window.dispose();
            window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
        }
    }
}
class CommonPanel extends JPanel {
    JButton btn = new JButton();

    CommonPanel() {

        add(btn);

    }

    public void init() {
        Window win = SwingUtilities.windowForComponent(this); // null :-(
        Window windowAncestor = SwingUtilities.getWindowAncestor(this); // null
                                                                        // :-(
        Container parent = getParent(); // null :-(
        JRootPane rootPane = SwingUtilities.getRootPane(btn); // null :-(

        rootPane.setDefaultButton(btn); // obvious NullPointerException...

    }
}
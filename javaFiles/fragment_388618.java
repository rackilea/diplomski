private class ActivateAllAction extends AbstractAction {

    public ActivateAllAction(String name) {
        super(name);
        int mnemonic = (int) name.charAt(1);
        putValue(MNEMONIC_KEY, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Add code for performing action here
        Component comp = tabbedPane.getSelectedComponent();
        if (comp instanceof DrawPanel2) {
            DrawPanel2 drawPanel = (DrawPanel2) comp;
        }
    }
}
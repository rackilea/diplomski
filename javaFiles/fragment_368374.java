public class ShowItemAction extends AbstractAction {

    private JList list;

    public ShowItemAction(JList list) {
        this.list = new JList();
        putValue(NAME, "Showing ...");

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int index = list.getSelectedIndex();
                    String value = list.getSelectedValue().toString();
                    putValue(NAME, "Showing " + value + " @ " + index);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // The actual action to be performed when selected
    }

}
// both height and width depend on content
final JTextField field = new JTextField() {

    @Override
    public Dimension getPreferredSize() {
        Dimension dim = super.getPreferredSize();
        int length = getText().length();
        dim.width += length * 10;
        dim.height += length * 2;
        return dim;
    }

};
// controller listens to changes to dynamically takes over the ui's job 
DocumentListener l = new DocumentListener() {

    protected void validateEditor(final JTextField field) {
        // the selectionModel's rowMapper is-a AbstractLayoutCache
        // BEWARE: implementation detail!
        TreeSelectionModel model = tree.getSelectionModel();
        // invalidate all cached node sizes/locations
        ((AbstractLayoutCache) model.getRowMapper()).invalidateSizes();
        // just a fancy cover method for revalidate/repaint
        tree.treeDidChange();
        // manually set the component's size
        field.setSize(field.getPreferredSize());
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        validateEditor(field);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        validateEditor(field);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }

};
field.getDocument().addDocumentListener(l);
public void actionPerformed(ActionEvent evt) {
    JComponent source = (JComponent) evt.getSource();
    Container tabComponent = source.getParent();
    int tabIndex = jTabbedPane1.indexOfTabComponent(tabComponent);
    jTabbedPane1.removeTabAt(tabIndex);
}
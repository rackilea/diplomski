for(int i = 0; i < tabbedPane.getTabCount(); i++) {
    if(SwingUtilities.isDescendingFrom(textField, tabbedPane.getComponentAt(i))) {
        tabbedPane.setTitleAt(i, textField.getText());
        break;
    }
}
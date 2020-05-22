public void actionPerformed(ActionEvent e) {
    bnum = false;
    num = Integer.parseInt(NumberEntry.getText());
    Object source = e.getSource();
    if (source instanceof Component) {
        // Close the dialog....
        SwingUtilities.getWindowAncestor((Component)source).dispose();
    }
}
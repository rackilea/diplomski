private JPanel aFunc() {
    custSelectPanel.setLayout(null);

    customerTable.setDragEnabled(false);
    customerTable.setFillsViewportHeight(true);

    ......

    cancelButton.setLocation(350, 0);
    cancelButton.setSize(100, 40);
    buttonPanel.add(cancelButton);

    return custSelectPanel;
}
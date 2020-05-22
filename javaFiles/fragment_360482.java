String[] bookArray = {"a", "b", "c"};
JComboBox bookComboBox = new JComboBox(bookArray);
bookComboBox.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        bookNameSelected = (String) cb.getSelectedItem();
        System.out.println("book name selected:" + bookNameSelected);
    }
});
bookComboBox.setSelectedIndex(0);
private void populateCols(int a1, int a2, int b1, int b2) {
    String[] lines;
    lines = readFile();
    jComboBox1.removeAllItems();

    for (String str : lines) {
       jComboBox1.addItem(str.substring(a1, a2) + " " + str.substring(b1, b2));
    }
}
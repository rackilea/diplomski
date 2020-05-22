DocumentListener dlBarcode = new DocumentAdaptor() {
public void insertUpdate(DocumentEvent e) {
    String value = jtBarcode.getText();
    if (isBarcode(value)) {
        PerformSearch ps = new PerformSearch(value);
        ps.execute();
    }
}
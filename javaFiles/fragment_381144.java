public void getInvoiceInfo(int id, DefaultTableModel model) {

    /** Load products from DB **/
    List<Product> products = is.getInvoiceInfo(id);
    for (int i = 0; i < products.size(); i++) {
        model.insertRow(i, new Object[] {
                products.get(i).getID(),
                products.get(i).getName(),
                products.get(i).getType(),
                products.get(i).getPrice(),
                products.get(i).getQuantity()
        });
    }
}
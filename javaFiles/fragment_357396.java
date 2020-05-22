private void jButtonSumActionPerformed(java.awt.event.ActionEvent evt) {                                          
    TableModelDrinks model = (TableModelDrinks) jTable1.getModel();
    float result = 0;
    for (int i = 0; i < model.getRowCount(); i++) {
        Drink d = model.drinkAt(i);
        result += d.getPrice() * d.getQuantity();
    }
    NumberFormat format = NumberFormat.getCurrencyInstance();
    JOptionPane.showMessageDialog(jTable1, "Your total price is: " + format.format(result), "Price", JOptionPane.INFORMATION_MESSAGE);
}
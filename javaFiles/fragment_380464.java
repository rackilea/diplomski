@Override
public void actionPerformed(ActionEvent evt) {
  //Get the newly added list values.
  JList list = productList.getSelectedValuesList();
  double totalAddedValue = 0.0;
  double oldCartValue    = 0.0;

  //Iterate to get the price of the new items.
  for (int i = 0; i < list.getModel().getSize(); i++) {
    CartItem item = (CartItem) list.getModel().getElementAt(i);
    totalAddedValue += Double.ParseDouble(item.getPrice());
  }

  //Set total price value as an addition to cart total field.

  //cartTotalField must be accessible here.
  string cartFieldText = cartTotalField.getText();

  //Check that cartTextField already contains a value.
  if(cartTextField != null && !cartTextField.isEmpty())
  {
    oldCartValue = Double.parseDouble(cartFieldText);
  }

  cartTotalField.setText(String.valueOf(oldCartValue  + totalAddedValue));
  checkoutBasket.addElement(list);
}
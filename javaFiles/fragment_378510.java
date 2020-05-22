public ObservableList<Long> itemList = FXCollections.observableArrayList(); 
   BigInteger bi1, bi2;
   Long l1, l2;
  // assign values to bi1, bi2
  bi1 = new BigInteger("-123");
  bi2 = new BigInteger("9888486986");
  // assign the long values of bi1, bi2 to l1, l2
  l1 = bi1.longValue();
  l2 = bi2.longValue();
  itemList.add(l1);
  itemList.add(l2);
   cmb_payType.setItems(itemList);
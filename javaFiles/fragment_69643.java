public List createListOfItemPurchased(ResultSet rs){
 List<ItemPurchase> purchaseList=new ArrayList<ItemPurchase>();
 while(rs.next()){
   ItemPurchase purchaseObject=new ItemPurchase();
   purchaseObject.setPrice(rs.getString("price"));
 //fill all required data in it
  purchaseList.add(purchaseObject);
 }
  return purchaseList;
}
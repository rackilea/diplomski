String result="";
for(int i=0;i<itemList.size();i++){
  String name = itemList.get(i).ItemName;
  String quanty = itemList.get(i).Quantity;
  result=result.concat(name+"-"+quanty+"$");
}
Log.d("OderHistory:",result);
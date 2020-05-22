double valuetotal=0.0;
if(item!=null && item.getValue()!=null){
  String tempString = item.getItemProperty("Amount")
                          .getValue()
                          .toString()
                          .replace(",","");
  valuetotal=Double.parseDouble(tempString);
}
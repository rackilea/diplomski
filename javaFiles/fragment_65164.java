public String getFirstResult(){
  String firstResult;
  TableHelper datahelper = new TableHelper(context);
  Cursor cursor = datahelper.getInformation();
  cursor.moveToFirst();
  firstResult = cursor.getString(0);
  return firstResult;
}
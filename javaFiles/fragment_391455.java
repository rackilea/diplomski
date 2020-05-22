List<List<Object>> mainList = new ArrayList<List<Object>>();
for (--each inner list entry--) {
    List<Object> innerList = new ArrayList<Object>();
    String dateString = SomeDateFormatter.formatDate(theDate, "yyyy-MM-dd h:mmA");
    innerList.add(dateString);
    BigDecimal theValue = new BigDecimal("4");
    innerList.add(theValue);
    mainList.add(innerList);
}
String jsonString = SomeJsonSerializer.serializeList(mainList);
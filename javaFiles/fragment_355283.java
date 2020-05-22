List<Number> listNumber = new ArrayList<Number>();
listNumber.add(5L);
listNumber.add(10L);
listNumber.add(25L);
List<Long> listLong = getList(listNumber, Long.class);
System.out.println(listNumber);
System.out.println(listLong);
//this line will throw CastClassException because elements in listNumber are Long only
List<Short> listShort = getList(listNumber, Short.class);
System.out.println(listShort);
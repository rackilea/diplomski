HashMap<String,Date> items = new HashMap<String, Date>();
items.put("item1", new Date());
items.put("item2", new Date());

List<HashMap<String, Date>> list = new ArrayList<HashMap<String, Date>>();
list.add(items);

testMethod(list, "more", "data");
ListMultimap<String, String> multimap = LinkedListMultimap.create();
multimap.put("x", "1");
multimap.put("x", "2");
multimap.put("y", "3");

XStream xStream = new XStream(new DomDriver());
xStream.registerConverter(new MapEntryConverter(xStream.getMapper()));

xStream.alias("add", multimap.getClass());
String xml = xStream.toXML(multimap);
System.out.println(xml);
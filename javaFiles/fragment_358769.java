ArrayList<HashMap<String, List<String>>> eventosList = new ArrayList<HashMap<String, List<String>>>();
HashMap<String, List<String>> contact = new HashMap<String, List<String>>();

List<String> list = new ArrayList<String>();
list.add("1");
list.add("2");
contact.put("id", list);
List<String> list1 = new ArrayList<String>();
list1.add("Mohammed");
list1.add("Ali");
contact.put("name", list1);
eventosList.add(contact);
public Item() throws ParseException {
JsontoList j = new JsontoList();
array = j.getarray();
list1 = j.toList(array);
list = j.getList(array);

List<String> types = new ArrayList<String>();
types = list;

//Added this piece of code below

Set<String> hs = new HashSet<>();
// add elements to List types, including duplicates
hs.addAll(types);
types.clear();
types.addAll(hs);
}
List<List<String>> indexList = new ArrayList<List<String>>();
List<String> a = new ArrayList<String>();
a.add("1");
a.add("2");
List<String> b = new ArrayList<String>();
b.add("1");
List<String> c = new ArrayList<String>();
c.add("3");
c.add("4");
indexList.add(a);
indexList.add(b);
indexList.add(c);
List<String> res = new ArrayList<String>();
combine(indexList, new int[indexList.size()], 0, res);
for (String s : res) {
    System.out.println(s);
}
List<String> al = new ArrayList<String>();
al.add("renu");
String[] as = new String[1];
as = al.toArray(as); // this is how we convert a List into an array
for (int i = 0; i < as.length; i++) {
    System.out.println(as[i]);
}
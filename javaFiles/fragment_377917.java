String[] a = {"a","b","c","d"};
String[] b = {"b", "c"};

//this is to avoid calling Arrays.asList multiple times
List<String> aL = Arrays.asList(a);
List<String> bL = Arrays.asList(b);

//finding the common element for both
Set<String> common = new HashSet<>(aL);
common.retainAll(bL);

//now, the real uncommon elements
Set<String> uncommon = new HashSet<>(aL);
uncommon.addAll(bL);
uncommon.removeAll(common);
return uncommon;
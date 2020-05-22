List<String> list = new ArrayList<> (name);
list.removeAll(name2); //list contains items only in name

List<String> list2 = new ArrayList<> (name2);
list2.removeAll(name); //list2 contains items only in name2

list2.addAll(list); //list2 now contains all the not-common items
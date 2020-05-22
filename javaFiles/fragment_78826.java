ArrayList list = new ArrayList(); //raw typed
list.add("entry"); //add a string
String s = (String)list.get(0); //but return type is Object, because list in raw typed

ArrayList<String> list2 = new ArrayList<String>(); //strong typed
list2.add("entry"); //add a string
String s2 = list2.get(0); //return type is String, because list2 is strong typed
List<Temporary> tempList = new ArrayList<>(); // create list

Temporary temp = new Temporary();  // create Temporary object
temp.setId(42);
temp.setName("a");
temp.setValue("b");
tempList.add(temp);  // add it to the list

temp = new Temporary();  // create new Temporary object
temp.setId(36);
temp.setName("c");
temp.setValue("d");
tempList.add(temp);  // add it to the list

temp = new Temporary();  // create new Temporary object
temp.setId(42);
temp.setName("e");
temp.setValue("f");
tempList.add(temp);  // add it to the list
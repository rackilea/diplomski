Collection collection=new HashSet();
collection.add("zebra");
collection.add("frog");
collection.add("bison");
collection.add("puma");
ArrayList<String> temp = new ArrayList<String>(collection);
Collections.sort(temp);
collection = new HashSet(temp);
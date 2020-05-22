List<String> filteredList = new ArrayList<String>();
for(Iterator<String> iterator = collection.iterator(); iterator.hasNext();) {
    String str = iterator.next();
    if(str.startsWith("a")) {
        filteredList.add(str);
    }
 }
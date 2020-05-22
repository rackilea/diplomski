Set<String> uniques = new HashSet<String>();
for(String item: tagList){
    // split the row into array of comman seperated elements
    String[] splitItem = item.split(",");
    for (String item: splitItem) {
        uniques.add(item.trim()); // trimming whitespace and adding to set

...
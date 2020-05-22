List<String> tmp = new ArrayList<String>(Arrays.asList(newArray));
for(String s : myArray) {
    if(!tmp.contains(s)) {
        tmp.add(s);
    }
}
newArray = tmp.toArray(new String[tmp.size()]);
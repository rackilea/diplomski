ArrayList<ArrayList<String>> source = new ArrayList<ArrayList<String>>();
List<List<String>> temp = new ArrayList<List<String>>();
for (ArrayList<String> list : source) {
    temp.add(Collections.unmodifiableList(list));
}
List<List<String>> out = Collections.unmodifiableList(temp);
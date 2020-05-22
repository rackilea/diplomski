Set<String> seen = new HashSet<String>();
List<String> ds3 = new ArrayList<String>();
for (String s : list1) {
    if (seen.contains(s))
        ds3.add(s);
    else
        seen.add(s);
}
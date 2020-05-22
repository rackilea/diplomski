List<String> uncommon = new ArrayList<> ();
for (String s : name) {
    if (!name2.contains(s)) uncommon.add(s);
}
for (String s : name2) {
    if (!name.contains(s)) uncommon.add(s);
}
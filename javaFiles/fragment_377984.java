Set<String> setB = new HashSet<>(listB);
for (String item : listA) {
 if (!setB.contains(item)) {
    newList.add(item);
 }
}
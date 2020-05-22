// Example ArrayList with Integer values
ArrayList<Integer> intList = new ArrayList<Integer>();
intList.add(2);
intList.add(2);
intList.add(2);
intList.add(2);
intList.add(7);

Set<Integer> noDupes = new HashSet<Integer>();
noDupes.addAll(intList); // Remove duplicates

for (Integer i : noDupes) {
    int occurrences = Collections.frequency(intList, i);
    System.out.println(i + " occurs " + occurrences + " times.");
}
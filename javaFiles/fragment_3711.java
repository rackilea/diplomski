String a[] = {"PAK", "ENG", "IND", "USA"};
String b[] = {"ON", "UK","IND","ENG","SA"};

/* Convert your arrays to lists */
final List<String> listA = Arrays.asList(a);
final List<String> listB = Arrays.asList(b);

/* Create another list holding 'duplicate' elements */
final List<String> duplicatesList = new ArrayList<String>(listA);
duplicatesList.retainAll(listB);

/* Finally create a resulting list as a + b - duplicates */
final List<String> result = new ArrayList<String>(listA);
result.addAll(listB);
result.removeAll(duplicatesList);

System.out.println(result);
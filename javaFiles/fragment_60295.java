List<String> verbs = new ArrayList<String>(
          Arrays.asList(new String[]{"have", "going", "leaving"}));
String[] arr = str.split("\\s+"); // split words
int i;
for (i=0; i<arr.length; i++) { // find word "work" and save the index
    if (arr[i].equals("work"))
        break;
}
boolean found = false;
for (int j=i-1; j>0 && j >= i-4; j--) { // go backwards and search your verbs
    System.out.printf("Finding: %s%n", arr[j]);
    if (verbs.contains(arr[j])) {
        found = true; // found it, break now
        break;
    }
}
System.out.printf("Found: %s%n", found);
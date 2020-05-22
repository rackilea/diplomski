List<String> fruit = new ArrayList<>();
fruit.add("apple");
fruit.add("orange");
fruit.add("banana");

boolean found = false;
for (String s : fruit) {
    if (s.equals("banana")) {
        found = true;
        break; // Break out of the loop to skip the remaining items
    }
}
if (found) {
    System.out.println("Found");
} else {
    throw new SkipException("could not be found");
}
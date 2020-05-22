List<String> fruit = new ArrayList<>();
fruit.add("apple");
fruit.add("orange");
fruit.add("banana");

if (fruit.stream().anyMatch(s -> s.equals("banana"))) {
    System.out.println("Found");
} else {
    throw new SkipException("could not be found");
}
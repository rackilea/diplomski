List<String> mylist = new ArrayList<>();
mylist.add("test");
mylist.add("test1");

Predicate<String> equalsIgnoreCasePredicate = str -> str.equalsIgnoreCase("test");
boolean noneMatchString = mylist.stream().noneMatch(equalsIgnoreCasePredicate);

if (noneMatchString) {
    System.out.println("Value is not Present");
}
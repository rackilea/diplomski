List<List<Integer>> oddCollection = new ArrayList<>();
List<Integer> numbers = new ArrayList<Integer>() {{
    add(1);
    add(2);
    add(3);
}};
oddCollection.add(numbers);
System.out.println(oddCollection.size()); // prints 1
System.out.println(oddCollection.get(0).size()); // prints 3
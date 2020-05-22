Integer[] numbers = {17, 42, 2001};
List<Integer> list = Arrays.asList(numbers);
System.out.println(list.get(0)); // Prints 17.
list.remove(0);  // throws.
numbers[0] = 1;
System.out.println(list.get(0)); // Prints 1.
list.set(0, 17);
System.out.println(numbers[0]);  // Prints 17.
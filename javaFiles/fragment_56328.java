Integer[] array = {1,2,3};
List<Integer> list = Arrays.asList(array);
array[1] = 10;
System.out.println(list); // Prints [1, 10, 3]

Integer[] array = {1,2,3};
List<Integer> list = List.of(array);
array[1] = 10;
System.out.println(list); // Prints [1, 2, 3]
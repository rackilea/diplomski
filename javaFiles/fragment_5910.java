int[] a = {1,2,3,4,5,6,7,8,9,10,11};

IntStream firstPart = Arrays.stream(a).limit(7);
IntStream secondPart = Arrays.stream(a).skip(8);
IntStream finalStream = IntStream.concat(firstPart, secondPart);
finalStream.forEach(System.out::println);
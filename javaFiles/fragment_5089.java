List<Integer> ints = Stream.of(2,8,7,4,3).collect(Collectors.toList());
System.out.print("the list: ");
ints.forEach((i) -> {
    System.out.print(i + " ");
                     ^^^^^^^ <-- this is different
});
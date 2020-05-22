List<Integer> list = Arrays.asList(10, 6, 16, 46, 5, 16, 7);
int search = 16;
int[] indices = IntStream.range(0, list.size())
                .filter(i -> list.get(i) == search)
                .toArray();
System.out.printf("Found %d at indices %s%n", search, Arrays.toString(indices));
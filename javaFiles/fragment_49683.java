int[] position = { 5, 6 };
ArrayList<int[]> test = new ArrayList<>();
test.add(new int[] {50, 2});
test.add(new int[] {0, 7});
test.add(position);
test.add(new int[] {2, 1});

System.out.println(Arrays.toString(position));
System.out.println(Arrays.toString(test.get(2)));

System.out.println(test.contains(position));
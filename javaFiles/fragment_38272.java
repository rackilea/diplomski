List<Integer> list = new ArrayList<>();
Random rand = new Random();
for (int i = 0; i < 10000; i++) {
    list.add(rand.nextInt(100) + 1);
}
list.sort(Comparator.reverseOrder());
System.out.println(list);             //[100, 100, 100, 100, 100, 100, 100, 100 ...
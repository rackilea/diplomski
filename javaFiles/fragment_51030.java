List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
Spliterator<Integer> spl1 = list.spliterator();
list.add(5);
list.add(6);
Spliterator<Integer> spl2 = spl1.trySplit();
spl1.forEachRemaining(System.out::print);
spl2.forEachRemaining(System.out::print);
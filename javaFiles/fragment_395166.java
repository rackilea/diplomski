int size = 1000000;
Random rand = new Random((int) (System.currentTimeMillis() / 1000));
List<Integer> yourList = new ArrayList<>(size);
for (int i = 0; i < size; i++) {
    yourList.add(rand.nextInt(10000));
}
// test1: LinkedHashSet --> 35ms
new ArrayList<Integer>(new LinkedHashSet<Integer>(yourList));
// test2: Stream distinct --> 30ms
yourList.stream().distinct().collect(Collectors.toList());
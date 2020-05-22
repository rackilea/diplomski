Random rnd = new Random(System.currentTimeMillis());
...
ArrayList<Integer> places = new ArrayList<Integer>(NUMBER);
for (int i = 0; i < NUMBER; ++i) {
  places.add(i);
}
Collections.shuffle(places, rnd);
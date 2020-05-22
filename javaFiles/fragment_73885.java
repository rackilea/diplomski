PriorityQueue<Integer> q = new PriorityQueue<Integer>(size, Collections.reverseOrder());
PriorityQueue<Integer> q2 = new PriorityQueue<Integer>(size, Collections.reverseOrder());

// code that adds items to q

for (Integer item: q) {
   q2.add(--item);
}
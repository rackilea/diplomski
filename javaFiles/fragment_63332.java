Queue<String> q1 = new LinkedList<>();
Queue<Integer> q2 = new LinkedList<>();

q1.add("North");
q1.add("East");
q1.add("West");
q2.add(1);
q2.add(2);
q2.add(3);

Iterator<String> i1 = q1.iterator();
Iterator<Integer> i2 = q2.iterator();

while (i1.hasNext() && i2.hasNext()) {
    System.out.println(i2.next() + " Mile(s) " + i1.next());
}
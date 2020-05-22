Iterator<String> itr1 = collection1.iterator();
Iterator<String> itr2 = collection2.iterator();
for (int i = 0; itr1.hasNext() && itr2.hasNext(); i++) {
  if (!itr1.next().equals(itr2.next())) {
    System.out.println(i);
    break;
  }
}
// traditional for loop
for (int i = 0; i < collection.size(); i++) {
  T obj = collection.get(i);
  // snip
}

// using iterator
Iterator<T> iter = collection.iterator();
while (iter.hasNext()) {
  T obj = iter.next();
  // snip
}

// using iterator internally (confirm it yourself using javap -c)
for (T obj : collection) {
   // snip
}
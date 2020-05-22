List<Foo> originalList = ...;

// Create new List with same capacity as original (for efficiency).
List<Foo> copy = new ArrayList<Foo>(originalList.size());

for (Foo foo: originalList) {
  copy.add((Foo)foo.clone());
}
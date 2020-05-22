Iterator<PhysicalActivity> iter = all.iterator();
while (iter.hasNext ()) {
  PhysicalActivity p = iter.next();
  ...
  if (...) {
    iter.remove();
  }
}
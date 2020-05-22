class SetOfObjects implements Iterable<SubObject> {

  // ...

  @Override public Iterator<SubObject> iterator() {
    return setOfObjects.iterator();
  }
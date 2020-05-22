Ordering<Multiset.Entry<E>> highestCountFirst = 
  new Ordering<Multiset.Entry<E>>() {
    @Override public int compare(Multiset.Entry<E> e1, Multiset.Entry<E> e2) {
      return Ints.compare(e1.getCount(), e2.getCount());
    }
  };
ImmutableMultiset.Builder<E> top100Builder = ImmutableMultiset.builder();
for (Multiset.Entry<E> topEntry : 
       highestCountFirst.greatestOf(multiset.entrySet(), 100)) {
  top100Builder.addCopies(topEntry.getElement(), topEntry.getCount());
}
return top100Builder.build();
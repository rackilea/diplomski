class myComplicatedCollection<T> implements Collection<T> {
     // Code goes here

     // O no, I still have to deal with the read-only use-case.
     // Instead of duplicating almost all of my code or using inheritance I'll use this handy-dandy wrapper
     public Collection<T> readonlyVersion() {
          return Collections.unmodifiableCollection(this);
     }
}
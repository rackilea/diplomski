private final Supplier<T> dflt;
  public Vec(Supplier<T> dflt) {
      super(); 
      this.dflt = Objectes.requireNonNull(dflt); 
  }
  ...
           if (super.get(a)==null) {
               super.insertElementAt(dflt.get(), a);
           }
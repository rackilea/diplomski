PrimitiveIterator.OfInt it=new PrimitiveIterator.OfInt() {
    int last=-2;
    public int nextInt() {
      if(last==-2 && !hasNext())
          throw new NoSuchElementException();
      try { return last; } finally { last=-2; }
    }
    public boolean hasNext() {
      if(last==-2)
        try { last=reader.read(); }
        catch(IOException ex) { throw new UncheckedIOException(ex); }
      return last>=0;
    }
};
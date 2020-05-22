class A {
   private B b1;
   private B b2;

   private class TheBees implements Iterable<B> {
     public Iterator<B> iterator() {
       return new Iterator<B> () {
         private int which = 0;
         public boolean hasNext() { return which < 2; }
         public B next() {
           which++;
           if (which == 1) return b1;
           if (which == 2) return b2;
           throw new NoSuchElementException ();
         }
         public void remove() { throw new UnsupportedOperationException (); }
       };
     }
   }

   public Iterable<B> theBees () {
     return (new TheBees ());
   }

   // other stuff...
}
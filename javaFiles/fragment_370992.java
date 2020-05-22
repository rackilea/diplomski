Collection<T> ts;
f(ts, new Predicate<T> () { 
            public boolean test(T element) { 
                      return element.equals("foo"); 
            }
 });

Collection<P> ps;
f(ps, new Predicate<P> () { 
            public boolean test(P element) { 
                      return element.getT().equals("foo"); 
            }
});
It is imperative that the user manually synchronize on the returned list when iterating over it:

        List list = Collections.synchronizedList(new ArrayList());
                 ...
             synchronized (list) {
                 Iterator i = list.iterator(); // Must be in synchronized block
                 while (i.hasNext())
                     foo(i.next());
             }

Failure to follow this advice may result in non-deterministic behavior.
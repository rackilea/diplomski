134        * Atomically sets to the given value and returns the old value.
135        *
136        * @param newValue the new value
137        * @return the previous value
138        */
139       public final V getAndSet(V newValue) {
140           while (true) {
141               V x = get();
142               if (compareAndSet(x, newValue))
143                   return x;
144           }
145       }
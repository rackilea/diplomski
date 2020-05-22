public Enumeration<E> More ...elements() {
312         return new Enumeration<E>() {
313             int count = 0;
314 
315             public boolean More ...hasMoreElements() {
316                 return count < elementCount;
317             }
318 
319             public E More ...nextElement() {
320                 synchronized (Vector.this) {
321                     if (count < elementCount) {
322                         return elementData(count++);
323                     }
324                 }
325                 throw new NoSuchElementException("Vector Enumeration");
326             }
327         };
328     }
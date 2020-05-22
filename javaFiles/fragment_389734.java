public Enumeration<E> elements() {
        return new Enumeration<E>() {  // return implemented enumeration
            int count = 0;

            public boolean hasMoreElements() {
                return count < elementCount;
            }

            public E nextElement() {  // implementing nextElement
                synchronized (Vector.this) {
                    if (count < elementCount) {
                        return elementData(count++); 
                          // accessing vector elements data which 
                         //traverses an array of object
                    }
                }
                throw new NoSuchElementException("Vector Enumeration");
            }
        };
    }
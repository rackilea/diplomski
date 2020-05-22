public Integer get(int i) {
          return a[i]; // Autoboxing (Item 5)
 }


 public Integer set(int i, Integer val) {
       int oldVal = a[i];
       a[i] = val; // Auto-unboxing
       return oldVal; // Autoboxing
 }

 public int size() {
     return a.length;
 }
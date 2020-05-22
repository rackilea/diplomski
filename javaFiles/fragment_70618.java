public boolean equals(Object rhs) {
    if (rhs instanceof Patient) {  // First Line
      return compareTo((Patient) rhs) == 0; // Second Line
    } else {
      return false;
    }
 }
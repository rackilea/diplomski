Domino previous = null;
    for (Domino current : dominos) {
       if (previous != null) {
          if (current.getLeftValue() != previous.getRightValue()) {
             throw new Exception("Illegal arrangement detected");
          }
       }
       previous = current;
    }
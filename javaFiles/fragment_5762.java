if (v1.getClass() == v2.getClass()){
           if (v1 instanceof Comparable){
               Comparable b1 = (Comparable) v1;
               Comparable b2 = (Comparable) v2;
               return b1.compareTo(b2) == 0 ? BigDecimal.ONE : BigDecimal.ZERO;
           } else {
               throw new IllegalStateException("Comparable expected instead of: "
                   + v1.getClass().getName());
           }
       } else {
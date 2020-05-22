class Circle{
     double radius;

       @Override
       public int hashCode() {
           return Double.valueOf(radius).hashCode();
       }

       @Override
       public boolean equals(Object obj) {
           if (obj == this) {
               return true;
           }
           if (obj instanceof Circle) {
               Circle circle =  (Circle)obj;
               return this.radius == circle.radius;
           }
           return false;
      }
  }
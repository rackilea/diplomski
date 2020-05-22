class Geometry {
   ...
   public void print() {
      System.out.println(shape_name);
      System.out.println(material);
   }
}

class Shape extends Geometry {
   ...
   public void print() {
      System.out.println(radius);
      System.out.println(center);
      super.print();
   }
}
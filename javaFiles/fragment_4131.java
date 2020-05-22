class MyInt {
   private Integer i;

   public MyInt(Integer i) {
      this.i = i;
   }

   public Integer getI() {
      return i;
   }

   @Override
   public int hashCode() {
      System.out.println("MyInt HashCode: " + i.hashCode());
     return i.hashCode();
   }

   @Override
   public boolean equals(Object obj) {
      System.out.printf("MyInt equals: [%s, %s]%n", i, obj);
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      MyInt other = (MyInt) obj;
      if (i == null) {
         if (other.i != null)
            return false;
      } else if (!i.equals(other.i))
         return false;
      return true;
   }

   @Override
   public String toString() {
      return i.toString();
   }

}
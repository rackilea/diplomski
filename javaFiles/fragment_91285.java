class Money {
   long units;
   int precision;

   public Money (long un, int prec)  {
     units =  un;
     precision = prec;
   }

   public int compareTo(Money other) {
      int preResult = this.precision - other.precision;
      long first =  (preResult > 0) ?  ((long)(this.units / Math.pow(10, preResult))) : this.units;
      long second = (preResult < 0) ?  ((long)(other.units * Math.pow(10, preResult))) : other.units;
      return (first == second) ? preResult : Long.compare(first, second);
   }

   public static void test() {
      Money first  = new Money(2345L, 4);
      Money second = new Money(234567L, 6);
      System.out.println(first.compareTo(second));
   }

}
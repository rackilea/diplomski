class Divider {
   protected int divisor;

   public void setDivisor(int divisor) {
       //we need to check the input to make sure our Divider works correctly 
       if (divisor == 0)
           throw new IllegalArgumentException("divisor can't be zero");
       this.divisor = divisor;
   }

   public int divide(int number) {
       return number/divisor;
   }
}
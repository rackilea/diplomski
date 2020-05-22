class Phone
{
   private int[] numbers; //I'm supposed to keep the array private
   public Phone(int theLength){
       numbers = new int[theLength];
   }
   public int[] getPhone(){
      return numbers;
   }

   @Override
   public String toString() {
       return Arrays.toString(numbers);// also can use  return Arrays.toString(numbers).replaceAll(",|\\[|\\]| ", ""); to clean up the , and []s
   }
}
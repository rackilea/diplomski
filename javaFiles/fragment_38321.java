public class Adder{
   public void addAndPrint(int x, int y){

      //code that will work on both Android and desktop
      int sum = x+y;

      if (ANDROID){
         //code that will only work on Android
         Log.v("example", "Sum:" + sum);
      }
      else{
         //code that will only work on desktop
         System.out.println("Sum: " + sum)
      }
   }
}
public class testRandom{

  public static void main (String [] args){
    Random rg = new Random();
   int x;
   for(int i = 0; i < 100; i++){
    x = rg.nextInt(6) + 1;
    System.out.println(x);
   }

  }


}
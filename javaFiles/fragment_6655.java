public class Main {
  public static void main(String[] args) {

      for (int n = 16; n<2049; n*=2){
          //System.out.println(Math.log(n) +"\t"+ n + "\t"+ (Math.log(n)*n)+"\t"+Math.pow(n,2)+"\t"+Math.pow(n,3)+"\t"+Math.pow(2,n)+"\t");
          System.out.printf( "%12.5f\t %6d\t %12.5f\t %14.0f\t %14.0f\t %16.0f\n",
              Math.log(n), n,
              Math.log(n)*n,
              Math.pow(n,2),
              Math.pow(n,3),
              Math.pow(2,n));
      }
  }
}
public class Factorial{
  int fact(int n) {
    int result;
    if(n==1) return 1;
    result=fact(n-1)*n;
    System.out.println("Fat(" + n + ")=" + result);
    return result;
  }

  public static void main(String[] args){
    Factorial fat = new Factorial();
    System.out.println("Final=" + fat.fact(5));
  }
}
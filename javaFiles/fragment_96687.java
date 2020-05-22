public class Reverse {
  public static int reverse(int... n) {
    if (n.length == 1) return reverse(n[0]/10,n[0]%10);
    else if (n[0] == 0) return n[1];
    else return reverse(n[0]/10,10*n[1]+n[0]%10);
  }

  public static void main(String[] args) {
    System.out.println(reverse(Integer.parseInt(args[0])));
  }
}
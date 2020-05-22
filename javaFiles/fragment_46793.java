public class exercise10 {
    public static int gcd(int a, int b) {
        if (b > 0) {
            int r = a % b;
            return gcd(b, r);
        }
        return a;
    }
    public static void main(String[] arguments){
        System.out.println(gcd(36,20));
    }

}
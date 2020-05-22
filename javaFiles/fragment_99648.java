public class Test {
      public static void main(String[] args) {
        double ulp = Math.ulp(Double.MAX_VALUE);
        System.out.println(ulp);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MAX_VALUE+ulp/2.0000000001);
        System.out.println(Double.MAX_VALUE+ulp/2);
      }
    }
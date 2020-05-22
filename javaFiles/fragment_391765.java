public class One {
   static String s1="hello";
   static String s2="world";

   static String display(s1,s2){ return s1+s2; }

   public static void main(String[] args) {

    String s3=display(s1,s2);
    System.out.println(s3);
   }
}
public class Test {

    public static void main(String[] args) {

        String s1 = "My Computer";
        String s2 = "My" + " Computer";
        String s3 = "My";
        String s4 = s3 + " Computer";

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s4); //false
    }
}
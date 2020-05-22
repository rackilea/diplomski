import java.util.Arrays;

public class TwinString {
    public static void main(String[] args) {
        System.out.println(isTwin("史密斯是王明的朋友", "朋友史密斯是王明的"));       
        System.out.println(isTwin("acab", "abac"));
        System.out.println(isTwin("acab", "abacd"));

        System.out.println(isTwin("hello", "world"));// false
        System.out.println(isTwin("abc", "cab"));// true
        System.out.println(isTwin("Lookout", "outlook"));// true    
    }

    public static boolean isTwin(String a, String b) {
        byte[] ab = a.toLowerCase().getBytes();
        byte[] bb = b.toLowerCase().getBytes();
        Arrays.sort(ab);
        Arrays.sort(bb);
        return new String(ab).equals(new String(bb));
    }
}
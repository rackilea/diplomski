public class test
{
    public static void main(String[] args)
    {
        System.out.println(containsMultiples("Hello World"));
        System.out.println(containsMultiples("faaaantastic"));
        System.out.println(containsMultiples(2, "Hello World"));
    }

    public static boolean containsMultiples(int n, String s) {
        int len = s.length();
        if(len == 0) return false;
        char lastChar = s.charAt(0);
        int multipliesFound = 1;

        for(int i = 1; i < len; i++) {
            if(s.charAt(i) == lastChar) {
                multipliesFound++;
            }
            else {
                multipliesFound = 1;
            }
            if(multipliesFound == n) {
                return true;
            }
            lastChar = s.charAt(i);
        }
        return false;
    }

    public static boolean containsMultiples(String s) {
        return containsMultiples(3, s);
    }
}
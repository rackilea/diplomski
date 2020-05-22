public class StringTest {

    public static void main(String[] args) {
        String str1 = "test";
        String str2 = "bev";
        String str3 = "tbtetse";
        System.out.println(isStringPresent(str1, str2, str3));
    }

    private static boolean isStringPresent(String str1, String str2, String str3) {

        if ((str1.length() + str2.length()) != str3.length()) {
            return false;
        } else {
            String[] str1Arr = str1.split("");
            String[] str2Arr = str2.split("");
            for (String string : str1Arr) {
                if (!str3.contains(string)) {
                    return false;
                }
            }
            for (String string : str2Arr) {
                if (!str3.contains(string)) {
                    return false;
                }
            }
        }
        return true;
    }
}
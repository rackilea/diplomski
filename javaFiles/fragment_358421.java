public class Task1 {
    public static void main(String[] args) {
        System.out.println(lowerCase("HELLO"));
        System.out.println(upperCase("hello"));
    }

    private static String lowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 65 && ch <= 90) //ASCII value of 'A'is 65 and that of 'Z' is 90
                sb.append((char)(ch+32));           
            else
                sb.append((char)ch);
        }
        return sb.toString();
    }
    private static String upperCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 97 && ch <= 122) //ASCII value of 'a'is 97 and that of 'z' is 122
                sb.append((char)(ch-32));           
            else
                sb.append((char)ch);
        }
        return sb.toString();
    }
}
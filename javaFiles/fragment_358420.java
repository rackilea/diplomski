public class Task1 {
    public static void main(String[] args) {
        System.out.println(lowerCase("HELLO"));
    }

    private static String lowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 65 && ch <= 90) 
                sb.append((char)(ch+32));           
            else
                sb.append((char)ch);
        }
        return sb.toString();
    }
}
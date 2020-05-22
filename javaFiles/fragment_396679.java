import java.util.regex.*;

class Test {
    public static void main(String[] args) {
        String str = "_6654_1";

        Pattern p = Pattern.compile("_(\\d+)_1");
        Matcher m = p.matcher(str);
        if (m.matches())
            System.out.println(m.group(1));  // prints 6654
    }
}
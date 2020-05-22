import java.util.*;

public class Test {
    public static void main(String... args) {
        String s = "12*1*145*2+8*1*1+2*3+2+4";
        List<String> tokens = new ArrayList<>();
        // for building numbers
        StringBuilder builder = new StringBuilder();
        // assume there are only 2 types (number and operators)
        boolean isNumber = false;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!isNumber) {
                    builder = new StringBuilder();
                    isNumber = true;
                }
                builder.append(c);
            } else {
                if (isNumber) {
                    tokens.add(builder.toString());
                    isNumber = false;
                }
                // assume operators are exactly 1 char
                tokens.add(String.valueOf(c));
            }
        }
        if (isNumber)
            tokens.add(builder.toString());
        System.out.println(tokens);
    }
}
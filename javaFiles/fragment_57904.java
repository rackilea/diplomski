import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest1 {

    public static void main (String args[] ) {

        String input[] = { "namein", "namenotin"};

        String operatorExpr = "(?<operator>(in)|(notin))";
        String conditionExpr ="(?<operand1>\\S+?)"+  operatorExpr;

        Pattern p = Pattern.compile(conditionExpr);

        for(String in: input) {

            Matcher m = p.matcher(in);
            if (m.find()) {

                String operand1 = m.group("operand1");
                String operator = m.group("operator");
                System.out.println("Input: \""+in + "\" | Operand1 : \""+ operand1 + "\"" + "| Operator : \""+ operator + "\"");

            }
        }

    }

}
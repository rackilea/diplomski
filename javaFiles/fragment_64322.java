import java.util.regex.*;

public class RegexTester {

    public static void main(String[] args) {
        String str2Check = "3x+2";

        //Find x - \\d{1,}+[x-x]
        //Find y-intercept [[\\+] | [\\-]]+\\d{1}

        String regexStringCoefficient = "[[\\+] | [\\-]]+\\d{1}";

        regexChecker(regexStringCoefficient, str2Check);
    }

    public static void regexChecker(String regexString, String str2Check){

        Pattern checkRegex = Pattern.compile(regexString);
        Matcher regexMacher = checkRegex.matcher(str2Check);

        while (regexMacher.find()){
            if (regexMacher.group().length() != 0){
                System.out.println(regexMacher.group());
                System.out.println("First Index: " + regexMacher.start());
                System.out.println("Ending index: " + regexMacher.end());
            }
        }
    }

}
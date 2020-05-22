import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDigits {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        // Validate Input
        String number = console.nextLine();
        Pattern p = Pattern.compile("(-?[0-9]{1})+");
        Matcher m = p.matcher(number);
        if (!m.matches()) {
            throw new IllegalArgumentException("Invalid Numbers");
        }
        // Calculate
        p = Pattern.compile("-?[0-9]{1}+");
        m = p.matcher(number);
        int result = 0;
        System.out.print("The digits of the number are:  ");
        while (m.find()) {
            System.out.print(m.group() + " ");
            result += Integer.valueOf(m.group());
        }
        System.out.println("");
        System.out.println("Result " + result);

    }

}
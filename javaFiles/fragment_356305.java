import java.util.regex.*;

public class JavaRegEx2 {
public static void main(String[] args) {
    String line = ", 0,003, 0,06, 0,22, 1,01 , -0,015, 0,06, 0,21, 1,02";
    String pattern = "(\\d+),(\\d+)";

    String updated = line.replaceAll(pattern, "$1.$2"); 

    System.out.println(updated);

}
}
import java.util.regex.Pattern;

public class Spike {

public static void main(String[] args) {
    testIt("Q");
    testIt("q");
    testIt("z");
    testIt("Z");
    testIt("R");
    testIt("r");
    testIt("0");
    testIt("1");
    testIt("2");
    testIt("3");
    testIt("4");
    testIt("5");
    testIt("6");
    testIt("7");
    testIt("02");
    testIt("11");
    testIt("17");
    testIt(""); // should fail, used to pass with the question's regex

}

public static void testIt(String sample) {
    System.out.print(sample+" ");
    if (Pattern.matches("[RQrq1-6]*", sample)) {
        System.out.println("match");
    } else {
        System.out.println("fail");
    }
}
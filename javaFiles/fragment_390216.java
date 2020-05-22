import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String report = "";
            for (int i = 0; i < 30; i++) {
                report += sc.nextLine()+" ";
            }
            System.out.println(report);
        }
    }
}
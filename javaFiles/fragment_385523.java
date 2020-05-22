import java.util.Scanner;

public class Bat {

    private String string;

    public Bat(String string) {
        this.string = string;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Bat bat = new Bat(str);
        bat.printStringBits();
    }

    private String stringBits() {
        String result = "";
        for (int i = 0; i < string.length(); i += 2) {
            result += string.substring(i, i + 1);
        }
        return result;
    }

    public void printStringBits() {
        System.out.println(stringBits());
    }
}
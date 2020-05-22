import org.apache.commons.io.IOCase;

public class Main {
    public static void main(String[] args) {
        System.out.println(IOCase.SENSITIVE.checkEndsWith("abcd1234", "1234"));
    }
}
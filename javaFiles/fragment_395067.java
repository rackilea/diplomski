package staticimport;
import static staticimport.DataGen.Options.*;

public class Tester {
    public static void main(String[] args) {
        String k = DataGen.generateString(5, OPTION1 | OPTION2);
    }
}
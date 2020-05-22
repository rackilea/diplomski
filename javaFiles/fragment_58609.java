import java.time.*;
import java.time.format.*;

public class Test {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("d/M/yyyy");
        System.out.println(LocalDate.parse("05/1/2015", parser));
        System.out.println(LocalDate.parse("05/01/2015", parser));
        System.out.println(LocalDate.parse("05/12/2015", parser));
        System.out.println(LocalDate.parse("5/12/2015", parser));
    }
}
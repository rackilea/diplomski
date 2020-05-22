import java.util.regex.Pattern;

public class PatternTest {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("schema1|schema2");
        System.out.println(p.matcher("schema0").matches());
        System.out.println(p.matcher("schema1").matches());
        System.out.println(p.matcher("schema2").matches());
        System.out.println(p.matcher("schema3").matches());
    }
}
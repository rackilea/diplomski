import java.util.regex.Pattern;

public class UrnTest {
    public final static Pattern URN_PATTERN = Pattern.compile(
        "^urn:[a-z0-9][a-z0-9-]{0,31}:([a-z0-9()+,\\-.:=@;$_!*']|%[0-9a-f]{2})+$",
        Pattern.CASE_INSENSITIVE);


    public static void main(String[] args) throws Exception {
        for(String urn : args) {
            boolean isUrn = URN_PATTERN.matcher(urn).matches();
            System.out.println(urn+"  :  "+(isUrn ? "valid" : "not valid"));
        }
    }
}
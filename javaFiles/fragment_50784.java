import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        String content = "\"sasl.jaas.config=com.sun.security.auth.module.Krb5LoginModule REQUIRED \r\n" + 
            "storeKey=true principal='test@test.net' validate=true serviceName=esaas \r\n" + 
            "keyTab='<some value>' useKeyTab=true;\"";
        Pattern pattern = Pattern.compile("keyTab='(.*?)'");
        Matcher matcher = pattern.matcher(content);
        matcher.find();
        System.out.println(matcher.group(1)); //<some value>
    }
}
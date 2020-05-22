import java.util.regex.*;

public class JavaRegEx {
public static void main(String[] args) {
    String line = "LanguageID=0,LastKnownPeriod=\"Active\",c_MultiPartyCall={Counter=1,TimeStamp=1394539271448},LTH={Data=[\"1|MTC|01.01.1970 15:00:00|0.0|7|-1|OnPeakAccountID|0|1000||\",\"1|MTC|01.01.1970 15:00:00|0.0|7|-1|OnPeakAccountID|0|1000||\"}";

    Pattern pattern = Pattern.compile("([\\w_]+=(?:\\{[\\w=_,\\[\\]\"\\|:\\.\\s-]*\\}))|([^,]+)");
    Matcher matcher = pattern.matcher(line);

    while(matcher.find())
        System.out.println(matcher.group(0));

}
}
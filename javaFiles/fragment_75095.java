import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

@SuppressWarnings("serial")
public class MatcherTest {

    @Test(expected = IllegalStateException.class)
    public void testIllegalState() {
        List<String> array = new ArrayList<String>() {{ add("Title: \"blah\""); }};
        Pattern p = Pattern.compile("(\".*\")");
        Matcher m = p.matcher(array.get(0).toString());
        System.out.println("Title : " + m.group(0));
    }

    @Test
    public void testLegal() {
        List<String> array = new ArrayList<String>() {{ add("Title: \"blah\""); }};
        Pattern p = Pattern.compile("(\".*\")");
        Matcher m = p.matcher(array.get(0).toString());
        if (m.find()) {
            System.out.println("Title : " + m.group(1));
        }
    }
}
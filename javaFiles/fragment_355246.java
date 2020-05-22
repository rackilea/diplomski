import java.io.InputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

public class Robots {

    public static void main(String[] args) {
        System.out.println(new Robots().getRobot("http://www.google.de/q?Stack Overflow"));
    }

    public String getRobot(String url) {
        Pattern p = Pattern.compile("^(http(s?)://([^/]+))");
        Matcher m = p.matcher(url);
        if (m.find()) {
            System.out.println(m.group(1));
            try (InputStream in = new URL(m.group(1) + "/robots.txt").openStream()) {
                return IOUtils.toString(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "no robots allowed";
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class RealIPScraper {
    private static final String URL_STRING = "http://www.realip.info/api/p/realip.php" ;

    private static final Pattern pattern = Pattern.compile("\\{\"IP\":\"(?<ip>.*)\"\\}");

    public static String getIP() throws IOException {
        URL url = new URL(URL_STRING);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()))) {
            String content = String.join("\n", in.lines().collect(Collectors.toList()));
            Matcher matcher = pattern.matcher(content);
            if (matcher.matches()) {
                return matcher.group("ip");
            } else {
                return "No ip found";
            }
        }
    }

}
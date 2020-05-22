import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Main {

    public static void main(String[] args) {
        String html = "<div id=\"content_heading\" style=\"background: url(http://images.multiplayer.it/thumbs/images/2014/06/10/assassins_creed_unity_jpg_1600x0_upscale_q85.jpg) center center; background-size: cover;\"></div>";
        final Pattern pattern = Pattern.compile("url\\((.+?)\\)");

        try {
            Document doc = Jsoup.parse(html);
            String url = doc.getElementById("content_heading").attr("style").toString();

            Matcher matcher = pattern.matcher(url);
            matcher.find();
            System.out.println(matcher.group(1));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

    public static void main(String[] args) {
        try {
            //In this url you must login
            String loginUrl = "http://slateisb.nu.edu.pk/portal/xlogin";

            //This is an example, it can be anything else
            String url = "http://slateisb.nu.edu.pk/portal";

            //First login. Take the cookies
            Connection.Response res = Jsoup
                    .connect(loginUrl)
                    .data("eid", "i110013")
                    .data("pw", "001")
                    .referrer("http://www.google.com")
                    .userAgent(
                            "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .method(Method.POST).timeout(0).execute();

            Map<String, String> loginCookies = res.cookies();

            //Now you can parse any page you want, as long as you pass the cookies
            Document doc = Jsoup
                    .connect(url)
                    .timeout(0)
                    .cookies(loginCookies)
                    .referrer("http://www.google.com")
                    .userAgent(
                            "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .get();

            System.out.println("Title : " + doc.title());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
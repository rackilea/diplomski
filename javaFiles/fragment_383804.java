import org.apache.commons.codec.binary.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

...

public static void main(String[] args) {

    String username = "username";
    String password = "password";
    String login = username + ":" + password;
    String base64login = new String(Base64.encodeBase64(login.getBytes()));

    Document document = Jsoup
        .connect("http://192.168.2.1")
        .header("Authorization", "Basic " + base64login)
        .get();

    Element e = document.select("body");
    ...
    /* Select the elements and HTML text you're interested here */
}
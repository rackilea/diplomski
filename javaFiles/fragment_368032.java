import org.jsoup.Jsoup;

public class Test {
    public static void main(String[] args){
        String html = "<html><head><title>HTML</title></head>"
              + "<body><p>Paragraph 1.</p><p>Paragraph 2.</p></body></html>";
        System.out.println(Jsoup.parse(html).body().text_mod());
    }
}
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test {
    public static void main(String[] args) throws Exception {
        test("http://www.foo.bar/");
        test("http://www.foo.bar/?q=a+b");
        test("http://www.foo.bar/?q=äöüß%"); // Will throw exception
    }

    private static void test(String url) throws Exception {
        String encoded = URLEncoder.encode(url, "UTF-8");
        String decoded = URLDecoder.decode(encoded, "UTF-8");
        System.out.println("encoded: " + encoded);
        System.out.println("decoded: " + decoded);
        System.out.println(URLDecoder.decode(decoded, "UTF-8"));
    }
}
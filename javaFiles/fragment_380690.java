import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlParamGenerator {
  private final String encoding;
  private final StringBuilder sb = new StringBuilder();
  private String separator = "?";

  public UrlParamGenerator(String charset) {
    this.encoding = charset;
  }

  public void add(String key, String value) throws UnsupportedEncodingException {
    sb.append(separator);
    sb.append(URLEncoder.encode(key, encoding));
    sb.append("=");
    sb.append(URLEncoder.encode(value, encoding));
    separator = "&";
  }

  @Override
  public String toString() {
    return sb.toString();
  }

  public static void main(String[] args) throws UnsupportedEncodingException {
    UrlParamGenerator gen = new UrlParamGenerator("UTF-8");
    gen.add("test", "\u0442\u0435\u0441\u0442");
    gen.add("x", "0");
    System.out.println(gen.toString());
  }
}
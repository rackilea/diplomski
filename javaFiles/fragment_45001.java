import java.util.regex.*;

class Untitled {
  public static void main(String[] args) {
    String input = "read(xpath('...'))";
    String result = null;
    Pattern regex = Pattern.compile("xpath\\(\'(.*?)\'\\)");
    Matcher matcher = regex.matcher(input);

    if (matcher.find()) {
        result = matcher.group(1);
    }

    System.out.println(result);
  }
}
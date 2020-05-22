private Pattern pattern;
private Matcher matcher;

private static final String HTML_PATTERN = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>";
/**
 * 
 */
public HTMLProcessor() {
    pattern = Pattern.compile(HTML_PATTERN);        
}

public String Process(String htmlString) {
    matcher = pattern.matcher(htmlString);
    if (matcher.find()) {
        do {
            System.out.println("Start:" + matcher.start() + ", end:" + matcher.end());
        } while(matcher.find());

        return htmlString.replaceAll(HTML_PATTERN, "");
    }
    return htmlString;
}

/**
 * @param args
 */
public static void main(String[] args) {
    // TODO Auto-generated method stub
    HTMLProcessor processor = new HTMLProcessor();
    String output = processor.Process("Some HTML <b id=\"boldtext\">text</b>");
    System.out.println(output);
}
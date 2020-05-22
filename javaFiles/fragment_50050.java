public static void extract(String str) {

    Pattern regex = Pattern.compile("(?mi)^((?:https?|ftp|file)://[-A-Z0-9+&@#/%?=~_|$!:,.;]*[A-Z0-9+&@#/%=~_|$]), (true|false), (.*)$");

    Matcher m = regex.matcher(str);
    while (m.find()) {
        System.out.println("URL:  " + m.group(1));
        System.out.println("Bool: " + m.group(2));
        System.out.println("Text: " + m.group(3) + "\n");
    }
}

public static void main (String[] args) throws java.lang.Exception
{
    String str = "http://www.yahoo.com, true, web mail site\nhttp://www.google.com, false, a search site";
    extract(str);
}
public static void main(String[] args) throws Exception {
    String[] lines = {
            "<li id=\"result_48\" data-asin=\"0781774047\" class=\"s-result-item\">",
            "<div id=\"result_48\" data-asin=\"0781774047\" class=\"s-result-item\">",
            "<div data-asin=\"0781774047\" id=\"result_48\" class=\"s-result-item\">",
            "<div data-asin=\"0781774047\" class=\"s-result-item\" id=\"result_48\">" };
    for (String str : lines) {
        System.out.println(extractId(str));
    }
}

private static String extractId(String line) {
    String regex = "";
    regex = regex + "(?:[<](?:li|div)).*id=\""; // match start until id="
    regex = regex + "([^\\s^\"]+)"; // capture the id inside quotes (exclude
                                    // spaces and quote)
    regex = regex + "(?:.*\">)"; // match any characters until the end ">
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(line);
    if (matcher.matches()) {
        return matcher.group(1);
    }
    return null;
}
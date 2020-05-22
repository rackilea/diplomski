private static final Pattern pattern = Pattern.compile("(.*?)\\[(.*?)\\]");

public static void extract(String input) {
    Matcher matcher = pattern.matcher(input);

    while (matcher.find()) {
        String text = matcher.group(1);
        String citation = matcher.group(2);

        System.out.println("The text: '" + text + "'\n\thas citation(s): " + citation);
    }
}
private static final Pattern pattern = 
    Pattern.compile("^ *(.+?)((?: +(?:[01][0-9]|2[0-3]):[0-5][0-9])+) *$");

public static final void splitLine(String line) {
    Matcher matcher = pattern.matcher(line);
    if (matcher.find()) {
        System.out.println("stop: " + matcher.group(1));
        System.out.println("times: " + matcher.group(2));
        // the time string will have the space(s) at the beginning, so it can be
        // concatenated without problem, but the first space might have to be trimmed
    }
}
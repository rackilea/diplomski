private static String getReplacementStage1(Matcher m, int c) {
    Pattern p1 = Pattern.compile(
            "<resource[^>]*?contentType=\"Evaluation\"", Pattern.MULTILINE
                    | Pattern.DOTALL);
    Matcher m1 = p1.matcher(m.group());
    if (!m1.find()) {
        // remove
        return "";
    }
    Pattern p2 = Pattern.compile("<propertyValue name=\"(?:RCSA|TRA)\"",
            Pattern.MULTILINE | Pattern.DOTALL);
    Matcher m2 = p2.matcher(m.group());
    if (m2.find()) {
        // remove
        return "";
    }
    // no change, return the group
    return m.group();
}
private String[][] extractSentenceContent(String sentence, String captureGroupA, String captureGroupB) {
    String pattern = String.format("^Send\\s(?<%s>[\\p{Alpha}\\s]+)\\sto\\s(?<%s>[\\p{Alpha}\\s]+)$", captureGroupA, captureGroupB);

    Matcher matcher = Pattern.compile(pattern).matcher(sentence);

    String[][] result;

    if(matcher.matches()) {
        result = new String[][] {
            {captureGroupA, matcher.group(captureGroupA)}, 
            {captureGroupB, matcher.group(captureGroupB)}
        };
    } else {
        result = null;
    }
    return result;
}
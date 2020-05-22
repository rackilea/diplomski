private static final Pattern PATTERN_VALIDATION = Pattern.compile("(\\s*-m\\s*[0-9]+\\s*)+");

public static void main(String[] args) {

    String test = "-m 5 -m444 -m 33 ";
    Matcher matcher = PATTERN_VALIDATION.matcher(test);
    System.out.println(matcher.matches());

}
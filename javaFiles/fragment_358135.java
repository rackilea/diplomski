private static final Pattern PATTERN = Pattern.compile(".*_(\\d{3})\".*");

public static void main(String[] args) throws ParseException {
    final String input = "<a target=\"_blank\" href=\"http://www.gazzetta.it/calcio/fantanews/statistiche/serie-a-2014-15/andrea_pirlo_669\">Pirlo A.</a>";
    final Matcher m = PATTERN.matcher(input);
    if (m.matches()) {
        System.out.println(m.group(1));
    } else {
        System.out.println("No match");
    }
}
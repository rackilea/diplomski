String in = "  what    893";
Pattern p = Pattern.compile("\\s*(\\S+)\\s+(\\d+)");
Matcher m = p.matcher(in);
if (m.matches()) {
    System.out.printf("%s %s%n", m.group(1), m.group(2));
}
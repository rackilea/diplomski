Matcher m = Pattern.compile("\\d+\\D+(\\d+)").matcher("2abc3abc4abc5");
if (m.find()) {
    do {
        allMatches.add(m.group());
    } while (m.find(m.start(1)));
}
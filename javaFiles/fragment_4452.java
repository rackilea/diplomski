String text = "This is a example text background and bunnies are red";
Pattern p = Pattern.compile("(example text)|(back)|(bunnies)|(red)", Pattern.CASE_INSENSITIVE);
Matcher m = p.matcher(text);

List<MatchRange> ranges = new ArrayList<>(25);
while (m.find()) {
    ranges.add(new MatchRange(m.start(), m.end()));
}

StringBuilder sb = new StringBuilder(64);
sb.append("<html>");
int anchor = 0;
for (MatchRange range : ranges) {
    String before = "";
    if (anchor < range.getStart()) {
        before = text.substring(anchor, range.getStart());
    }
    sb.append(before);
    System.out.println(range.getStart() + " - " + range.getEnd());
    String match = text.substring(range.getStart(), range.getEnd());
    // This is where I would have a rule formatter
    if (match.equals("example text")) {
        sb.append("<font color=\"FFFFFF\" style=\"background-color: #FFAABB\">");
        sb.append(match);
        sb.append("</font>");
    } else if (match.equals("back")) {
        sb.append("<font color=\"FFFFFF\" style=\"background-color: #AAAAAA\">");
        sb.append(match);
        sb.append("</font>");
    } else if (match.equals("bunnies")) {
        sb.append("<font color=\"FF0000\" style=\"background-color: #FFFFFF\">");
        sb.append(match);
        sb.append("</font>");
    } else if (match.equals("red")) {
        sb.append("<font color=\"FF0000\" style=\"background-color: #000000\">");
        sb.append(match);
        sb.append("</font>");
    } else {
        sb.append(match);
    }
    anchor = range.getEnd();
}

System.out.println(sb.toString());
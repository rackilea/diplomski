Matcher m = Pattern.compile("<ol start=\"(\\d)\">").matcher(text);
while (m.find()) {
    int n = Integer.parseInt(m.group(1));
    text = text.replace("<ol start=\"" + n + "\">", 
            "<ol>" + repeat("\n\t<li style=\"visibility:hidden\" />", n-1));
}
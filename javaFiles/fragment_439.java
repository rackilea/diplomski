Pattern p = Pattern.compile("Showing [0-9,]+ - [0-9,]+ of ([0-9,]+) matches");
Matcher m = p.matches(scrapedHTML);
if(m.matches()) {
    int num = Integer.parseInt(m.group(1).replaceAll(",", ""));
    // num == 1439
}
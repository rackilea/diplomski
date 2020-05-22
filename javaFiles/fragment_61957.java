String data = "Word ONE , this is WORD two and this is the word THREE, " +
        "(words will not be counted)";
Pattern p = Pattern.compile("\\bword\\b", Pattern.CASE_INSENSITIVE);
Matcher m = p.matcher(data);
int counter = 0;
while (m.find())
    System.out.println("[" + counter++ + "]" + m.group());
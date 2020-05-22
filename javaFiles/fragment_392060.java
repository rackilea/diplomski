String s = "Distal latency   4.9 N/A N/A 4.0 N/A N/A N/A N/A 6.3 4.4 N/A\n\n % failed Chicago Classification  70 1 1 0 1 1 1 1 0 0 1\n\n % panesophageal pressurization  0 0 0 0 0 0 0 0 0 0 0\n\n % premature contraction  20 0 0 1 0 0 0 0 0 1 0\n\n % rapid contraction  10 0 0 1 0 0 0 0 0 0 0\n\n % large breaks  10 0 0 0 0 0 0 0 1 0 0\n\n % small breaks  10 0 0 1 0 0 0 0 0 0 0";
Pattern match_patternSwallow2= Pattern.compile("(?m)^\\W*([a-zA-Z].*?)\\s*((?:(?:\\d+(?:\\.\\d+)?|N/A)\\s*)*)$");
Matcher matchermatch_patternSwallow2 = match_patternSwallow2.matcher(s);
HashMap<String, String> mapSwallow = new HashMap<String, String>();
while (matchermatch_patternSwallow2.find()){
    String[] myList = matchermatch_patternSwallow2.group(2).split("\\s+");
    String p1 = matchermatch_patternSwallow2.group(1).replaceAll("\\s+", "");
    int line = 1;
    for (String p2s: myList){
        mapSwallow.put(p1+line, p2s);
        line++;
    }
}
System.out.println(mapSwallow);
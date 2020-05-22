String input = "01:aa,bb,02:cc,03:dd,04:ee";
//                           | group 1
//                           || group 2: 2 digits
//                           ||       | separator
//                           ||       | | group 3: any character reluctantly quantified...
//                           ||       | |  | ... followed by ...
//                           ||       | |  |  | ... comma and next digit as 
//                           ||       | |  |  | non-capturing group...
//                           ||       | |  |  |     | ... or...
//                           ||       | |  |  |     || ... end of input
//                           ||       | |  |  |     ||   | multiple matches in input
Pattern p = Pattern.compile("((\\d{2}):(.+?(?=(?:,\\d)|$)))+");
Matcher m = p.matcher(input);
while (m.find()) {
    System.out.println(m.group(2) + " --> " + m.group(3));
}
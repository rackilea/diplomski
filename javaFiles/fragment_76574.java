String input = "<a><b><c></c></b></a>";

Pattern p = Pattern.compile("<(.+?)>");
Matcher m = p.matcher(input);

ArrayList<String> s = new ArrayList<String>();

while(m.find())
    s.add(m.group(1));

System.out.println(s.toString());
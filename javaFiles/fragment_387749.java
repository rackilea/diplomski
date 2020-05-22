String input = "HTML[0].BODY[0]/UL[1]/LI[10]/A[1]";

Pattern p = Pattern.compile("\\d+");
Matcher m = p.matcher(input);
StringBuffer sb = new StringBuffer();
while (m.find()) {
    m.appendReplacement(sb, String.valueOf(Integer.parseInt(m.group()) + 1));
}
m.appendTail(sb);

String output = sb.toString();

System.out.println(output);
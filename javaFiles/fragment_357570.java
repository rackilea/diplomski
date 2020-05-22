String s = "C*12.387a0d14assc7*18.65d142a";
StringBuffer result = new StringBuffer();
Matcher m = Pattern.compile("\\*(\\d+)\\.(\\d+)").matcher(s);
while (m.find()) {
    String num = m.group(1);
    String denom = m.group(2);
    String divisor = "1" + new String(new char[denom.length()]).replace("\0", "0");
    String replacement = "*" + num + denom + ":" + divisor;
    m.appendReplacement(result, replacement);
}
m.appendTail(result);
System.out.println(result.toString());
String strLine;
StringBuffer sb = new StringBuffer("");
while ((strLine = br.readLine()) != null) {
    sb.append(strLine + "\n");
}

Matcher m = Pattern.compile(delCommentsPattern,Pattern.MULTILINE).matcher(sb.toString());
while (m.find()) {
    String b = m.group();
    System.out.println(b);
}
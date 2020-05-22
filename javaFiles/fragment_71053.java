String str = "ZZZZL <%= dsn %> AFFF <%= AFG %>";
Pattern pattern = Pattern.compile("<%=(.*?)%>", Pattern.DOTALL);
Matcher matcher = pattern.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}
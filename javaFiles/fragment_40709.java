String s = "test179901034102 00:00:00:00:00:01 Open\n" +
    "test179901083723 00:00:00:00:00:01 Open\n" +
    "test179901153595 00:00:00:00:00:01 Open\n" +
    "test179901187836 00:00:00:00:00:01 Open";

Pattern pattern = Pattern.compile("^[^ ]+", Pattern.MULTILINE);
Matcher matcher = pattern.matcher(s);
while (matcher.find()) {
  System.out.println(matcher.group(0));
}
String s = "{'Im': {url:'\\/az\\/hprichbg\\/rb\\/?*<>WhiteTippedRose_ROW10477559674_1366x768.jpg', hash:'674'}";

Pattern p = Pattern.compile("[^\\/:*?\"<>|]+\\.jpg");
Matcher m = p.matcher(s);
if (m.find()) {
  String match = m.group();
  System.out.println(match);
}
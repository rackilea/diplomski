String order = "...";
Pattern p = Pattern.compile(".*VP15");
Matcher m = p.matcher(order);
if (m.find()) {
 String suffixes = order.substring(m.end() + 1);
 int index = 0;
 String[] suffixesArray = suffixes.split(",");
 for (String suffix : suffixesArray) {
   System.out.print("VP15 " + suffix + (index++ < suffixesArray.length - 1 ? ", " : ""));
 }
}
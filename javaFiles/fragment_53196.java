String line = "item 1 = $2 item 2 = $3 item 3 = $4";
Pattern pat = Pattern.compile("\\$([\\d]+)");
Matcher m = pat.matcher(line);
while (m.find()) {
    System.out.println(m.group(1));
}
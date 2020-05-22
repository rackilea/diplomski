Pattern p = Pattern.compile("^(\\w+://)?(.*?)/");
Matcher m = p.matcher(url); // string
if (m.matches()) {
  String tokens[] = m.group(2).split(".");
  // etc
}
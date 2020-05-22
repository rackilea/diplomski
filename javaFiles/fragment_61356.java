String str = "HH12HH";
Pattern p = Pattern.compile("(\\G(?!^)|^(?=(?:HH12|HH)+$))(?:HH12|HH)");
List<String> res = new ArrayList<>();
Matcher m = p.matcher(str);
while (m.find()) {
    res.add(m.group());
}
System.out.println(res);
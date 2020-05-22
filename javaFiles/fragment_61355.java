String str = "HH12HH";
Pattern p = Pattern.compile("HH12|HH");
List<String> res = new ArrayList<>();
if (str.matches("(?:HH12|HH)+")) { // If the whole string consists of the defined values
    Matcher m = p.matcher(str);
    while (m.find()) {
        res.add(m.group());
    }
}
System.out.println(res); // => [HH12, HH]
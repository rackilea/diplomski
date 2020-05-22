String regex = "[0-9]{1,2}([/-])[0-9]{1,2}\\1[0-9]{4}";
Pattern pattern = Pattern.compile(regex);
String json = "{\"x\":\"02/23/2019\",\n" + "\"y\":\"02-27-2019\"}";

Matcher matcher = pattern.matcher(json);
while (matcher.find()) {
    System.out.println(matcher.group());
}
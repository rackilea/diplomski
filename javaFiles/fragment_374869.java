Pattern pattern = Pattern.compile("(?:Active Phone Lines:|\\G)[\\s,]*([0-9]{4})");
String test = "User Names: bob, jill, toni, tom"+
              "Active Phone Lines: 1010, 2020, 3030, 4040, 5050, 6060, 7070"+
              "Inactive Phone Lines: 1111, 2222, 3333, 4444, 5555";
Matcher matcher = pattern.matcher(test);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}
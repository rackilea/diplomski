String line = "leak:   short(16)    long(3)";
Pattern pattern = Pattern.compile("leak:(?:\\s+short\\((\\d+)\\))?(?:\\s+medium\\((\d+)\\))?(?:\\s+long\\((\\d+)\\))?");
Matcher matcher = pattern.matcher(line);
while (matcher.find()) {

  //Stick them in your array.
  System.out.println("short " + matcher.group(1)); //16
  System.out.println("medium " + matcher.group(2)); //null
  System.out.println("long  " + matcher.group(3)); //3
}
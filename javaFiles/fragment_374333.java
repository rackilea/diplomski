String beforeTask = "au.com.newline.myact";
Pattern pattern = Pattern.compile("com[.](.*)[.]");
Matcher matcher = pattern.matcher(beforeTask);
while (matcher.find()) {
     String ct = matcher.group(1);//remember that regex finds Strings, not int
     System.out.println(ct);
}
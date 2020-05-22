String input = new String(Files.readAllBytes(Paths.get("file.sql")), "UTF-8");
String regex = "(?i)((create table|alter table add constraint foreign key)[^;]+;)"
        .replace(" ", "\\s+");
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(input);
while (matcher.find()) {
    System.out.println(matcher.group());
}
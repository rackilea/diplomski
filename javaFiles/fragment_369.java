Pattern COMPILE = Pattern.compile("(.+@[A-Za-z0-9.\"]+)(?:[:;,|]+)(.*)");
Matcher m = COMPILE.matcher(next);

if (m.find()) {
    System.out.println(m.group(1));
    System.out.println(m.group(2));
} else {
    System.out.println("NO MATCH");
}
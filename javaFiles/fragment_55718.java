Pattern p = Pattern.compile("/\\w*/raw/[0-9-]+/(\\w+)/.*");
Matcher m = p.matcher(str);
if (m.find()) {
    String value = m.group(1);
    System.out.println(value);
}
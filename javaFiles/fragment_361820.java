String input = "firstColumn         varchar(4)   not null,";

Pattern p = Pattern.compile("(.+?)\\s+(.+?)\\s+(.*)");
Matcher m = p.matcher(input);

if (m.find()) {
    System.out.println(m.group(1));
    System.out.println(m.group(2));
    System.out.println(m.group(3));
}
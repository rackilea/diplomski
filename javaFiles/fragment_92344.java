Pattern depArrHours = Pattern.compile("^(\\[(.+)\\])(\\[(.+)\\])(.+)\\/(.+)$");
Matcher matcher = depArrHours.matcher("[0-6, 1-3][01-20, 22-23]22/123");
if (matcher.matches()) {
    System.out.println(matcher.group(0));
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2));
    System.out.println(matcher.group(3));
    System.out.println(matcher.group(4));
    System.out.println(matcher.group(5));
    System.out.println(matcher.group(6));
}
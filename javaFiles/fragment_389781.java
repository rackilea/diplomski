Pattern p = Pattern.compile("(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3})");
//you could also use "d\\^(.*)Z" as your regex patern
Matcher m = p.matcher("your string here");

if (m.find()) {
    System.out.println(m.group(1)); //print out the timestamp
}
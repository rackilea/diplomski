String input = "Table xxx123\n" +
               "Seat 1: xxx (1537 xxx)\n" +
               "Seat 3: yyy (609 yyy)\n" +
               "Seat 5: zzz (485 zzz)\n" +
               "xxx123 HOLE";

String regex = "(?s)(?:(?<!^)\\G|Table).*?Seat (\\d).*?\\((\\d+)(?=.*?HOLE)";

Matcher m = Pattern.compile(regex).matcher(input);
while (m.find())
    System.out.println(m.group(1) + " " + m.group(2));
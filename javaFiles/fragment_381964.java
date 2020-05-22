String input = "we got a new member. he's name is: Peter. He is pretty nice. he "
            + "is a member of the group: devceloper. Also he's birthday is: 13.08.2001."
            + " As well we got a new member she's name is: Sara. She is pretty nice. "
            + "she is a member of the group: customer. Also her birthday is: 21.01.1998";

Pattern pattern = Pattern.compile("name[^:]*:\\s*(\\w+).*?group[^:]*:\\s*(\\w+).*?birthday[^:]*:\\s*(\\d+\\.\\d+\\.\\d+)");

Matcher matcher = pattern.matcher(input);

while(matcher.find()) {
    System.out.printf("Match found. name: %s, group: %s, birthday: %s %n", matcher.group(1), matcher.group(2), matcher.group(3));
}
@Test
public void testname() throws Exception {
    parseText("453=3~^448=0A~!447=D~!452=1~!~^448=0A~!447=D~!452=17~!~^448=81~!447=D~!452=7~!~^");
}

private int subgroupLength = 0;

public void parseText(String text) {
    for (String group : text.split("~\\^")) {
        System.out.println("Group");
        parseGroup(group);
    }
}

public void parseGroup(String group) {
    for (String attribute : group.split("~!"))
        parseAttribute(attribute);
}

public void parseAttribute(String attribute) {
    String[] split = attribute.split("=");
    if (split.length != 2)
        return;

    if (split[0].equals("453")) {
        System.out.println("\tSubgroup length " + split[1]);
        subgroupLength = Integer.parseInt(split[1]);
    } else if (subgroupLength > 0) {
        subgroupLength--;
        System.out.println("\t\t" + split[0] + " = " + split[1]);
    } else
        System.out.println("\t" + split[0] + " = " + split[1]);
}
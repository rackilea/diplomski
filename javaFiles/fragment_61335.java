// data string
String input = "\"aa\", \"a, aa\", [\"bb\", [\"1\", \"2\"]], [cc], [\"dd\", [\"5\"]]";
System.out.println(input);

// char that can't ever be within the data string
char tempReplacement = '#';
// escape strings containing commas, e.g "hello, world", ["x, y", 42]
while(input.matches(".*\"[^\"\\[\\]]+,[^\"\\[\\]]+\".*")) {
    input = input.replaceAll("(\"[^\"\\[\\]]+),([^\"\\[\\]]+\")", "$1" + tempReplacement + "$2");
}
// while there are "[*,*]" substrings
while(input.matches(".*\\[[^\\]]+,[^\\]]+\\].*")) {
    // replace the nested "," chars by the replacement char
    input = input.replaceAll("(\\[[^\\]]+),([^\\]]+\\])", "$1" + tempReplacement + "$2");
}

// split the string by the remaining "," (i.e. those non nested)
String[] split = input.split(",");

List<String> output = new LinkedList<String>();
for(String s : split) {
    // replace all the replacement chars by a ","
    s = s.replaceAll(tempReplacement + "", ",");
    s = s.trim();
    output.add(s);
}

// syso
System.out.println("SPLIT:");
for(String s : output) {
    System.out.println("\t" + s);
}
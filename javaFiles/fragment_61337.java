public static List<String> split(String input, char tempReplacement) {
    while(input.matches(".*\"[^\"\\[\\]]+,[^\"\\[\\]]+\".*")) {
        input = input.replaceAll("(\"[^\"\\[\\]]+),([^\"\\[\\]]+\")", "$1" + tempReplacement + "$2");
    }
    while(input.matches(".*\\[[^\\]]+,[^\\]]+\\].*")) {
        input = input.replaceAll("(\\[[^\\]]+),([^\\]]+\\])", "$1" + tempReplacement + "$2");
    }
    String[] split = input.split(",");
    List<String> output = new LinkedList<String>();
    for(String s : split) {
        output.add(s.replaceAll(tempReplacement + "", ",").trim());
    }
    return output;
}
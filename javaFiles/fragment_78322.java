String compoundCommand = null;
ArrayList<String> commandList = new ArrayList<String>();
String list = "";
int count = 0;

ArrayList<String> splitBashScript(String script) {
    script = script.replaceAll("\\\\\n", "");
    script = script.replaceAll("([^;]);([^;])", "$1\n$2");
    String[] lines = Pattern.compile("[ \t]*\n", Pattern.MULTILINE).split(script);
    String delimiter = null;
    for (String line : lines) {
        if (!line.isEmpty()) {
            if (compoundCommand == null) {
                if (line.matches(".*<<.*")) {
                    compoundCommand = "here";
                    delimiter = line.replaceFirst(".*<< *", "").replaceAll("\"", "");
                    list += line;
                } else if (line.matches("[ \t]*for[ \t]*.*")) {
                    compoundCommand = "for";
                    count++;
                    list += line;
                } else if (line.matches("[ \t]*select[ \t]*.*")) {
                    compoundCommand = "select";
                    count++;
                    list += line;
                } else if (line.matches("[ \t]*case[ \t]*.*")) {
                    compoundCommand = "case";
                    count++;
                    list += line;
                } else if (line.matches("[ \t]*if[ \t]*.*")) {
                    compoundCommand = "if";
                    count++;
                    list += line;
                } else if (line.matches("[ \t]*while[ \t]*.*")) {
                    compoundCommand = "while";
                    count++;
                    list += line;
                } else if (line.matches("[ \t]*until[ \t]*.*")) {
                    compoundCommand = "until";
                    count++;
                    list += line;
                } else if (list.isEmpty()) {
                    commandList.add(line.replaceFirst("[ \t]*&&$", ""));
                }
            } else if (compoundCommand.equals("here")) {
                list += "\n" + line;
                if (line.matches(delimiter)) {
                    compoundCommand = null;
                    commandList.add(list.replaceFirst("[ \t]*&&$", ""));
                    list = "";
                }
            } else if (compoundCommand.equals("for")) {
                compound(line, "(for|select|while|until)", "done");
            } else if (compoundCommand.equals("select")) {
                compound(line, "(for|select|while|until)", "done");
            } else if (compoundCommand.equals("case")) {
                compound(line, "case", "esac");
            } else if (compoundCommand.equals("if")) {
                compound(line, "if", "fi");
            } else if (compoundCommand.equals("while")) {
                compound(line, "(for|select|while|until)", "done");
            } else if (compoundCommand.equals("until")) {
                compound(line, "(for|select|while|until)", "done");
            }
        }
    }
    return commandList;
}

void compound(String line, String start, String end) {
    list += "\n" + line;
    if (line.matches("[ \t]*" + start + "[ \t]*.*")) {
        count++;
    }
    if (line.matches("[ \t]*" + end + "[ \t]*.*")) {
        count--;
    }
    if (count == 0) {
        compoundCommand = null;
        commandList.add(list.replaceFirst("[ \t]*&&$", ""));
        list = "";
    }
}
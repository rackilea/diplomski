static String EXAMPLE_INPUT =
   "a single line command;\n"
 + "-- a standalone comment\n"
 + "a multi\n"
 + "line\n"
 + "-- embedded comment\n"
 + "command;\n"
 + "multi -- line\n"
 + "command with double minus;\n"
 + "and just a last command;";

public static void main(String[] args) {
    Scanner s = new Scanner(EXAMPLE_INPUT).useDelimiter(";(\\R|\\Z)");
    while(s.hasNext()) {
        String command = s.next().replaceAll("(?m:^--.*)?+(\\R|\\Z)", " ");
        System.out.println("Command: "+command);
    }
}
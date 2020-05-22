public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_RED = "\u001B[31m";

public static void main(String[] args) {
    System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
}
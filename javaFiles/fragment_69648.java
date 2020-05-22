if (input.findInLine("(\\d+)\\s+(\\d+)") == null) {
    // expected pattern was not found
    System.out.println("Incorrect input!");
} else {
    // expected pattern was found - retrieve and parse the pieces
    MatchResult result = input.match();
    int temp1 = Integer.parseInt(result.group(1));
    int temp2 = Integer.parseInt(result.group(2));
    int total = temp1+temp2;

    System.out.println(total);
}
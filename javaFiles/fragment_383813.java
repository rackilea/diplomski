String[] tokens = s.split(" ");
String modified = "";
for (int i = 0 ; i < tokens.length ; i++) {
    // the digits are found
    if (Pattern.matches("\"[0-9]+\"", tokens[i])) {
        tokens[i] = "x" + tokens[i];
    }
    modified = modified + tokens[i] + " ";
}
Pattern pattern = Pattern.compile("max_len\[(?<maxLength>\d)\];");
Matcher match = pattern.matcher(string);
if (match.matches()) {
    int maxLength = Integer.parseInt(match.group("maxLength"));
    print("The maximum length is " + match.group("maxLength"));
} else {
    print("The string didn't match the pattern");
}
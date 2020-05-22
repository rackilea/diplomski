Pattern pattern = Pattern.compile("\\s*(\\d)\\s*([+-*/])\\s*(\\d)\\s*([+-*/])\\s*(\\d)\\s*([+-*/])\\s*(\\d)");
Matcher matcher = pattern.matcher(input);
while (!matcher.matches()) {
    // print error and accept new input
    matcher = pattern.matcher(input);
}

int result = Integer.parseInt(matcher.group(1));
for (int g = 2; g <=6; g+= 2) {
    switch (matcher.group(g)) {
    case '*':
        result *= Integer.parseInt(matcher.group(g + 1));
        break;
    case '+':
        result += Integer.parseInt(matcher.group(g + 1));
        break;
    // and so on
}
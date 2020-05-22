public static Iterable<String> split(String s) {
    List<String> result = new LinkedList<String>();
    Stack<String> stack = new Stack<String>();
    Pattern pattern = Pattern.compile("[,\\[\\]]|.+?");
    Matcher matcher = pattern.matcher(s);

    stack.push("");
    while (matcher.find()) {
        String token = matcher.group();
        if (token.equals("[")) {
            stack.push("");
        } else if (token.equals("]")) {
            if (! stack.peek().isEmpty())
                result.add(join(".", stack));
            stack.pop();
            stack.pop();
            stack.push("");
        } else if (token.equals(",")) {
            if (! stack.peek().isEmpty())
                result.add(join(".", stack));
        } else {
            stack.pop();
            stack.push(token);
        }
    }
    if (! (stack.isEmpty() || stack.peek().isEmpty()))
        result.add(join(".", stack));
    return result;
}
String input = "Fields  { name:\"aa\" type: \"bb\" paramA { name:\"cc\" } paramB { other:\"ee\" other_p:\"ff\"} paramC { name: \"bb\" param: \"dd\" other_params { abc: \"xx\" xyz:\"yy\"}} }";
Matcher m = Pattern.compile("\\s*(?:(\\w+)\\s*(?::\\s*(\".*?\")|\\{)|\\})\\s*").matcher(input);
int start = 0;
Deque<String> stack = new ArrayDeque<>();
while (m.find()) {
    if (m.start() != start)
        throw new IllegalArgumentException("Invalid data at " + start);
    if (m.group(2) != null) {
        System.out.println(stack + " : " + m.group(1) + " = " + m.group(2));
    } else if (m.group(1) != null) {
        //System.out.println(m.group(1) + " {");
        stack.addLast(m.group(1));
    } else {
        //System.out.println("}");
        if (stack.isEmpty())
            throw new IllegalArgumentException("Unbalanced brace at " + start);
        stack.removeLast();
    }
    start = m.end();
}
if (start != input.length())
    throw new IllegalArgumentException("Invalid data at " + start);
if (! stack.isEmpty())
    throw new IllegalArgumentException("Unexpected end of text");
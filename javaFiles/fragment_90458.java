public class BrokenXmlParser {

    public String parse(InputStream resource) throws IOException {

        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line + "\n");
            }
        }
        List<String> tokens = tokenize(builder.toString());
        return correct(tokens);
    }

    private String correct(List<String> tokens) {
        StringBuilder reassemble = new StringBuilder();
        reassemble.append("<root>");
        Deque<String> tagNameStack = new ArrayDeque<>();
        boolean skip = false;
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if ("<".equals(token)) {
                tagNameStack.push(tokens.get(i + 1));
            }
            if ("<?".equals(token) || "<!".equals(token)) {
                // skip comments
                skip = true;
            } else if ("<".equals(token)) {
                skip = false;
            }
            if ("</>".equals(token)) {
                reassemble.append("</" + tagNameStack.pop() + ">");
            } else if ("</".equals(token)) {
                // sometimes tags are incorrectly closed
                reassemble.append("</" + tagNameStack.pop() + ">");
                i = i + 2;
            } else if (!skip) {
                reassemble.append(token);
            }
        }
        reassemble.append("</root>");
        return reassemble.toString();
    }

    private List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();
        Pattern tag = Pattern.compile("(</>|<!|<\\?|\\?>|</|<|>|\\s+|[^<> ]+)");
        Matcher matcher = tag.matcher(input);
        while (matcher.find()) {
            tokens.add(matcher.group(1));
        }
        return tokens;

    }

}
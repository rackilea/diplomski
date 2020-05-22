private String extractNodeName(String nodeName) {
        String output = "";
        Matcher match = Pattern.compile("\\w+(?<!\\d|_)").matcher(nodeName);
        while (match.find()) {
            output = match.group();
        }
        return output;
}
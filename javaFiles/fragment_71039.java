private static String cleanStringForXPath(String dirtyString)
    {
        Pattern pattern = Pattern.compile("([^'\"]+|['\"])");
        Matcher matcher = pattern.matcher(dirtyString);

        int count = 0;
        StringBuilder sb = new StringBuilder();

        while(matcher.find()) {
            String part = matcher.group(1);
            if(part.equals("'")) {
                sb.append("\"'\"");
            } else if(part.equals("\"")) {
                sb.append("'\"'");
            } else { 
                sb.append("'" + part + "'");
            }
            sb.append(",");
            count++;
        }

    String result = sb.length() > 0 ? sb.substring(0, sb.length() - 1): "";
    return (count > 1) ? "concat(" + result + ")" : result;
}
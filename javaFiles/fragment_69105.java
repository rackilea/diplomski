public class Obfuscate {

    private static final Pattern VAR_PATTERN = Pattern.compile("\\b_(\\w+)\\b");
    private final Map<String, String> renames = new HashMap<>();

    public String obfuscate(String sourceCode) {
        StringBuffer buf = new StringBuffer(sourceCode.length() + 100);
        Matcher m = VAR_PATTERN.matcher(sourceCode);
        while (m.find()) {
            String var = m.group(1);
            String newVar = renames.get(var);
            if (newVar == null) {
                newVar = randomVar();
                renames.put(var, newVar);
            }
            m.appendReplacement(buf, newVar);
        }
        m.appendTail(buf);
        return buf.toString();
    }
}
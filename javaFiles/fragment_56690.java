public static void main(String[] args) {
        String patternString = createRegexFromGlob("abc*");
        List<String> list = Arrays.asList("abf", "abc_fgh", "abcgafa", "fgabcafa");
        list.forEach(it -> System.out.println(it.matches(patternString)));
}

private static String createRegexFromGlob(String glob) {
    StringBuilder out = new StringBuilder("^");
    for(int i = 0; i < glob.length(); ++i) {
        final char c = glob.charAt(i);
        switch(c) {
            case '*': out.append(".*"); break;
            case '?': out.append('.'); break;
            case '.': out.append("\\."); break;
            case '\\': out.append("\\\\"); break;
            default: out.append(c);
        }
    }
    out.append('$');
    return out.toString();
}
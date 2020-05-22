public static void main(String [] args) throws Exception {
    Process p = new ProcessBuilder(getCommand("perl -e \"print 5\"")).start();
    System.out.println(IOUtils.toString(p.getInputStream()));
    p.destroy();

}

private static String[] getCommand(String input) {
    StringTokenizer tokenizer = new StringTokenizer(input);
    String[] result = new String[tokenizer.countTokens()];
    for (int i = 0; tokenizer.hasMoreTokens(); i++) {
        result[i] = tokenizer.nextToken();
    }
    return result;
}
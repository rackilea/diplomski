public String transformString(String str) {
    try (BufferedReader bin = new BufferedReader(new StringReader(str));
            Writer bout = new StringWriter()) {

        transformBufferedReader(bin, bout);
        return bout.toString();
    } catch (IOException e) {
        throw new IllegalStateException("the string readers shouln't be throwing IOExceptions");
    }
}
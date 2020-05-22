public String replaceAll(String source) throws FileNotFoundException {
    String regex = "[A-Z]* |[a-z]*\\s";
    source = source.replaceAll(regex, "")
                   .replaceAll("\\d", "")
                   .toLowerCase();

    System.out.println(source);
    writetoFile(source);
    return source;
}
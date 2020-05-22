private String readFile(String path) throws FileNotFoundException {
    Scanner scanner = (new Scanner(new File(path)));
    String s = scanner.useDelimiter("\\Z").next();
    scanner.close();
    return s;
}
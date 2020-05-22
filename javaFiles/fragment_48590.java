private String[] getFileNames() throws URISyntaxException {
    URL url = getClass().getResource("/resources/images/");
    File file = new File(url.toURI());
    String[] fileNames = file.list();
    for (String s : fileNames) {
        System.out.println(s);
    }
    return fileNames;
}
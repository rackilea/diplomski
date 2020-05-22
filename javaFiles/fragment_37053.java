public static String deriveModule(String filename) {

    // strip ".jar" at the end
    filename = filename.replaceAll("\\.jar$", "");

    // drop everything after the version
    filename = filename.replaceAll("-\\d.*", "");

    // all non alphanumeric get's converted to "."
    filename = filename.replaceAll("[^A-Za-z0-9]", ".");

    // strip "." at beginning and end
    filename = filename.replaceAll("^\\.*|\\.*$", "");

    // all double "." stripped to single
    filename = filename.replaceAll("\\.{2,}", ".");


    return filename;
}
private final static char BOM = '\uFEFF';    // Unicode Byte Order Mark
String firstLine = readFirstLineOfFile("filename.txt");
if (firstLine.charAt(0) == BOM) {
    // We have a BOM
} else {
    // No BOM present.
}
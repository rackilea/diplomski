Path file = Paths.get(filePath);
String name = file.getFileName().toString();
String copiedName = name.replaceFirst("(\\.[^\\.]*)?$", "-copy$0");
Path copiedFile = file.resolveSibling(copiedName);
try {
    Files.copy(file, copiedFile);
} catch (IOException ex) {
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
}
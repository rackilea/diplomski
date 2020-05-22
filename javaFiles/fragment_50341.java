FileProcessor proc = extensionToProcessor.get(fileExtension);
if (proc != null) {
    proc.importFile(fileName);
} else {
    throw new UnknownFileException("Files of type '"+fileExtension"' are not supported.");
}
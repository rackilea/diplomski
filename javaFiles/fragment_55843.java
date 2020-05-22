String prefix = FilenameUtils.getBaseName(inpFile.getName()); 
String suffix = FilenameUtils.getExtension(inpFile.getName());
File file = File.createTempFile(prefix + "-", "." + suffix, "/path/to/uploads");

InputStream input = inpFile.getInputStream();
OutputStream output = new FileOutputStream(file);

try {
    IOUtils.copy(input, output);
} finally {
    IOUtils.closeQuietly(output);
    IOUtils.closeQuietly(input);
}

// Now you can use File.
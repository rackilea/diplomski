URL url = new URL("https://upload.wikimedia.org/wikipedia/en/8/87/Example.JPG");
try (InputStream in = url.openStream()) {
   Files.copy(in, Paths.get("someFile.jpg"), StandardCopyOption.REPLACE_EXISTING);
} catch (IOException e) {
   // handle exception
}
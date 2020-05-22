URL url = new URL(link);
Path imageFile = Files.createTempFile("image", null);
try (InputStream stream = url.openStream()) {
    Files.copy(stream, imageFile, StandardCopyOption.REPLACE_EXISTING);
}

image = ImageIO.read(imageFile.toFile());
String contentType = Files.probeContentType(imageFile);
Files.delete(imageFile);
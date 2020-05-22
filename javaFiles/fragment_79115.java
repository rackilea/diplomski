File tempFile = null;
try (InputStream in =
        getClass().getResourceAsStream("/PicturePackage/admin_input.wmv")) {
    Path temp = Files.createTempFile("temp", ".wmv");
    Files.copy(in, temp, StandardCopyOption.REPLACE_EXISTING);
    tempFile = temp.toFile();
    // This will try to delete the file when you close your java app
    tempFile.deleteOnExit(); 
} catch (Exception e) {
    // Handle the exceptions properly
}

// Here you can use tempFile to open it
if (tempFile != null) {
    try {
        Desktop.getDesktop().open(tempFile);
    } catch (IOException e) {
        // Handle exception
    }
}
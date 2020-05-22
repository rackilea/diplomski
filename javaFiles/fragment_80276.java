File recordsDir = new File(System.getProperty("user.home"), ".myApplicationName/records");
if (! recordsDir.exists()) {
    recordsDir.mkdirs();
}

// ...

FileChooser chooser = new FileChooser();
chooser.setInitialDirectory(recordsDir);
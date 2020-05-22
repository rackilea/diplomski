private void setupFileIO() {
    File storageDir = new File("/storage");
    File files[] = storageDir.listFiles();

    File directory = null;
    if (files != null && files.length > 0) {
        for (File f : files) {
            if (f.isDirectory() && f.getPath().toLowerCase().contains("usb") && f.canRead()) {
                directory = f;
                break;
            }
        }
    }
    if (directory != null && directory.canRead()) {
        File file[] = directory.listFiles();
        if (file != null && file.length > 0) {
            for (int i = 0; i < file.length; i++) {
                String filePath = file[i].getPath();
                String extension = Files.getFileExtension(filePath);
                if (file[i].isFile() && file[i].canRead() && extension.equalsIgnoreCase("bin")) {
                    try {
                        byte[] r = Files.toByteArray(file[i]);
                        String result = BaseEncoding.base16().encode(r);
                        // do something with result
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
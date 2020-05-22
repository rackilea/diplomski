private void getPdfFromExternalStorage(File folder) {
    if (folder != null) {
        if (folder.listFiles() != null) {
            for (File file : folder.listFiles()) {
                if (file.isFile()) {
                    //.pdf files
                    if (file.getName().contains(".pdf")) {
                        Log.d("filePath-------", "" + file.getPath());
                    }
                } else {
                    getPdfFromExternalStorage(file);
                }
            }
        }
    }
}
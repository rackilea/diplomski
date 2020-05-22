private File getFile() {
    File folder = new File("sdcard/UTP_app");
    if (!folder.exists()) {
        folder.mkdir();
    }

    return new File(folder, new Date().getTime()+".jpg");
}
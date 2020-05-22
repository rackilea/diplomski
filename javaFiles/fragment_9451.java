public static void openFile(File file) throws Exception {
    if (Desktop.isDesktopSupported()) {
        new Thread(() -> {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
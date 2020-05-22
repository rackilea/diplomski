public static void openFile(final String path) throws IOException{
        File file = new File(path);
        if ( file.exists() ) {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        }
    }